package com.liuwenhao.myblog.controller;

import com.liuwenhao.myblog.domain.page.PageParams;
import com.liuwenhao.myblog.domain.pojo.Article;
import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.vo.ArticleVo;
import com.liuwenhao.myblog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("文章管理")
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @ApiOperation("文章列表接口")
    @PostMapping()
    public Result list(@RequestBody PageParams pageParams){
        Result result= service.listAll(pageParams);
        return result;
    }
}
