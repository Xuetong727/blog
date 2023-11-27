package com.liuwenhao.myblog.controller;


import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.vo.param.RegisterParam;
import com.liuwenhao.myblog.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {


    @Autowired
    private RegisterService registerService;

    @PostMapping
    public Result register(@RequestBody RegisterParam param){

        return registerService.register(param);
    }

}
