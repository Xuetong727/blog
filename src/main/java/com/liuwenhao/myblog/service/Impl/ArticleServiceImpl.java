package com.liuwenhao.myblog.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwenhao.myblog.domain.page.PageParams;
import com.liuwenhao.myblog.domain.pojo.Article;
import com.liuwenhao.myblog.domain.vo.ArticleVo;
import com.liuwenhao.myblog.mapper.ArticleMapper;
import com.liuwenhao.myblog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper,Article> implements ArticleService {


    @Override
    public List<ArticleVo> listAll(PageParams pageParams) {

        Page<Article> articlePage = new Page<>();
        articlePage.setCurrent(pageParams.getPageNumber());
        articlePage.setSize(pageParams.getPageSize());
        Page<Article> page = page(articlePage);
        return null;
    }
}
