package com.liuwenhao.myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.page.PageParams;
import com.liuwenhao.myblog.domain.pojo.Article;
import com.liuwenhao.myblog.domain.vo.ArticleVo;

import java.util.List;

public interface ArticleService extends IService<Article>{

    Result listAll(PageParams pageParams);
}
