package com.liuwenhao.myblog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.page.PageParams;
import com.liuwenhao.myblog.domain.pojo.*;
import com.liuwenhao.myblog.domain.vo.ArticleBodyVo;
import com.liuwenhao.myblog.domain.vo.ArticleVo;
import com.liuwenhao.myblog.domain.vo.CategoryVo;
import com.liuwenhao.myblog.domain.vo.TagVo;
import com.liuwenhao.myblog.mapper.ArticleMapper;
import com.liuwenhao.myblog.mapper.ArticleTagMapper;
import com.liuwenhao.myblog.service.ArticleBodyService;
import com.liuwenhao.myblog.service.ArticleService;
import com.liuwenhao.myblog.service.CategoryService;
import com.liuwenhao.myblog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleBodyService articleBodyService;

    @Autowired
    private TagService tagService;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Autowired
    private CategoryService categoryService;

    @Override
    public Result listAll(PageParams pageParams) {

        Page<Article> articlePage = new Page<>();
        articlePage.setCurrent(pageParams.getPage());
        articlePage.setSize(pageParams.getPageSize());
        Page<Article> page = page(articlePage);

        Page<ArticleVo> articleVoPage = new Page<>();
        BeanUtils.copyProperties(page,articleVoPage);
        List<Article> records = page.getRecords();

        if(!records.isEmpty()){
            ArrayList<ArticleVo> articleVos = new ArrayList<>();
            articleVos = copyList(records,true,true,true);
            articleVoPage.setRecords(articleVos);
        }
        //较早版本
        return Result.success(articleVoPage.getRecords());

        // return Result.success(articleVoPage);
    }

    private ArrayList<ArticleVo> copyList(List<Article> records,Boolean withBody,Boolean withTag,Boolean withCategory) {
        ArrayList<ArticleVo> articleVos = new ArrayList<>();
        for (Article record : records) {
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(record,articleVo);
            if(withBody){
                ArticleBodyVo articleBodyVo = new ArticleBodyVo();
                ArticleBody articleBody = articleBodyService.getById(record.getBodyId());
                BeanUtils.copyProperties(articleBody,articleBodyVo);
                articleVo.setBody(articleBodyVo);
            }
            if(withTag){
                ArrayList<TagVo> tagVos = new ArrayList<>();
                LambdaQueryWrapper<ArticleTag> articleTagLambdaQueryWrapper =
                        new LambdaQueryWrapper<ArticleTag>().eq(ArticleTag::getArticleId,record.getId());
                List<ArticleTag> articleTags = articleTagMapper.selectList(articleTagLambdaQueryWrapper);
                List<Long> tagIds = articleTags.stream().map(ArticleTag::getTagId).collect(Collectors.toList());
                if(!tagIds.isEmpty()){
                    LambdaQueryWrapper<Tag> tagQueryWrapper =
                            new LambdaQueryWrapper<Tag>().in(Tag::getId,tagIds);
                    List<Tag> tagList = tagService.list(tagQueryWrapper);
                    if(!tagList.isEmpty()){
                        for (Tag tag : tagList) {
                            TagVo tagVo = new TagVo();
                            BeanUtils.copyProperties(tag,tagVo);
                            tagVos.add(tagVo);
                        }
                    }
                }

                articleVo.setTags(tagVos);
            }
            if(withCategory){
                CategoryVo categoryVo = new CategoryVo();
                Category category = categoryService.getById(record.getCategoryId());
                BeanUtils.copyProperties(category,categoryVo);
                articleVo.setCategory(categoryVo);
            }
            articleVos.add(articleVo);
        }

        return articleVos;
    }
}
