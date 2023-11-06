package com.liuwenhao.myblog.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("用户控制层")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "登录接口")
    @GetMapping("/login")
    public String login(){
        System.out.println("登录接口");
        return "登录成功";
    }


}
