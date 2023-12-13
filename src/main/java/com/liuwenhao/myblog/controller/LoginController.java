package com.liuwenhao.myblog.controller;


import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.vo.param.LoginParam;
import com.liuwenhao.myblog.service.LoginService;
import com.liuwenhao.myblog.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("登录模块")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParam param){
        System.out.println("1111111");
        Result result = loginService.login(param);
        return result;
    }
}
