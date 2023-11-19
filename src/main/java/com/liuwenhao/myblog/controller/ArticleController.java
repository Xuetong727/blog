package com.liuwenhao.myblog.controller;

import com.liuwenhao.myblog.domain.page.PageParams;
import com.liuwenhao.myblog.domain.pojo.Article;
import com.liuwenhao.myblog.domain.Result;
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
    @ApiOperation("最热标签")
    public Result hot(){
        int limit = 2 ;
        List<TagVo> tagVos = tagService.getHotTags(limit);

        return Result.success(tagVos);
    }

}
