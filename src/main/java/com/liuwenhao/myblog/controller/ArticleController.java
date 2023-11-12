package com.liuwenhao.myblog.controller;

import com.liuwenhao.myblog.domain.Article;
import com.liuwenhao.myblog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("文章管理")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @ApiOperation("文章列表接口")
    @GetMapping("/list")
    public List<Article> list(){
        List<Article> list = service.list();
        return list;
    }
}
