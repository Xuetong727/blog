package com.liuwenhao.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuwenhao.myblog.domain.pojo.ArticleTag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
    List<Long> selectHotIds(int limit);
}
