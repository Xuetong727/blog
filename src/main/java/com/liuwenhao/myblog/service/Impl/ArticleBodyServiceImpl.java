package com.liuwenhao.myblog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwenhao.myblog.domain.pojo.ArticleBody;
import com.liuwenhao.myblog.mapper.ArticleBodyMapper;
import com.liuwenhao.myblog.service.ArticleBodyService;
import org.springframework.stereotype.Service;

@Service
public class ArticleBodyServiceImpl extends ServiceImpl<ArticleBodyMapper, ArticleBody> implements ArticleBodyService {
}
