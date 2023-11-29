package com.liuwenhao.myblog.controller;


import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.vo.UserVo;
import com.liuwenhao.myblog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.liuwenhao.myblog.common.ErrorCode.NOT_LOGIN;

@Api("用户控制层")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "当前用户接口")
    @GetMapping("/currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){

        Result result = userService.getUserInfoByToken(token);
        return result;
    }





}
