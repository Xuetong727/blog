package com.liuwenhao.myblog.controller;


import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.vo.param.LoginParam;
import com.liuwenhao.myblog.service.LoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("退出登录模块")
@RestController
@RequestMapping("/logout")
public class LogoutController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public Result logout(@RequestHeader("Authorization") String token){
        Result result = loginService.logout(token);
        return result;
    }
}
