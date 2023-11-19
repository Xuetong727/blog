package com.liuwenhao.myblog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwenhao.myblog.domain.pojo.Tag;
import com.liuwenhao.myblog.domain.vo.TagVo;
import com.liuwenhao.myblog.mapper.ArticleTagMapper;
import com.liuwenhao.myblog.mapper.TagMapper;
import com.liuwenhao.myblog.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Override
    public List<TagVo> getHotTags( int limit) {
        List<TagVo> tagVos = new ArrayList<>();
        List<Long> tagIds = articleTagMapper.selectHotIds(limit);
        // ArrayList<Tag> hotTags = tagMapper.getHotTags();
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<Tag>().in(Tag::getId, tagIds);
        List<Tag> tags = tagMapper.selectList(queryWrapper);
        if(!tags.isEmpty()){
            for (Tag tag : tags) {
                TagVo tagVo = new TagVo();
                BeanUtils.copyProperties(tag,tagVo);
                tagVos.add(tagVo);
            }
        }
        return tagVos;
    }
}
