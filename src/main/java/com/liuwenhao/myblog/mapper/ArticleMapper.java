package com.liuwenhao.myblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuwenhao.myblog.domain.pojo.Article;
import com.liuwenhao.myblog.domain.vo.Archives;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> getArchives();

}
