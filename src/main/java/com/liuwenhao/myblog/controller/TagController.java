package com.liuwenhao.myblog.controller;


import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.vo.TagVo;
import com.liuwenhao.myblog.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api("标签接口")
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    // @GetMapping("/hot")
    // @ApiOperation("最热标签")
    // public Result hot(){
    //     int limit = 6 ;
    //     List<TagVo> tagVos = tagService.getHotTags(limit);
    //
    //     return Result.success(tagVos);
    // }


}
