package com.liuwenhao.myblog.controller;

import com.liuwenhao.myblog.domain.page.PageParams;
import com.liuwenhao.myblog.domain.pojo.Article;
import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.vo.Archives;
import com.liuwenhao.myblog.domain.vo.ArticleVo;
import com.liuwenhao.myblog.domain.vo.TagVo;
import com.liuwenhao.myblog.service.ArticleService;
import com.liuwenhao.myblog.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api("文章管理")
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @Autowired
    private TagService tagService;

    @ApiOperation("文章列表接口")
    @PostMapping()
    public Result list(@RequestBody PageParams pageParams){
        Result result= service.listAll(pageParams);
        return result;
    }


    @PostMapping("/hot")
    @ApiOperation("最热文章")
    public Result hot(){
        int limit = 5 ;
        List<ArticleVo> articleVos = service.getHotAtricles(limit);
        return Result.success(articleVos);
    }


    @PostMapping("/new")
    @ApiOperation("最新文章")
    public Result lastedArticle(){
        int limit = 5 ;
        List<ArticleVo> lastedArticles = service.getLastedArticle(limit);
        return Result.success(lastedArticles);
    }


    @PostMapping("/listArchives")
    @ApiOperation("文章归档")
    public Result listArchives(){

        List<Archives> archives = service.getArchives();
        return Result.success(archives);
    }

}
