package com.liuwenhao.myblog.handler;


import com.alibaba.fastjson.JSON;
import com.liuwenhao.myblog.common.ErrorCode;
import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.pojo.SysUser;
import com.liuwenhao.myblog.service.UserService;
import com.liuwenhao.myblog.utils.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    public static ThreadLocal<String> userThreadLocal = new ThreadLocal<>();

    @Autowired
    private UserService userService;


    // @Autowired
    // private UserService userService;
    //
    // @Override
    // public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //     boolean successLogin = userService.checkLogin(request);
    //     if(!successLogin){
    //         request.setAttribute();
    //     }
    //     return
    // }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果不是HandlerMethod就是ResourceHttpRequestHandler，就直接放行
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        userThreadLocal.set(Thread.currentThread().getName());
        System.out.println(userThreadLocal.get());
        System.out.println(userThreadLocal);
        String token = request.getHeader("Authorization");
        // String[] tokenS = authorization.split("TOKEN_");//这是在redis里的,请求头里每有前缀
        // if(tokenS.length == 0){
        //     response.sendRedirect(request.getContextPath()+"/login");
        // }
        // String token = tokenS[0];
        if(StringUtils.isBlank(token))
        {
            //这样子只会让浏览器地址变成这个.同时没有附上参数,method也没有设置,并不能达到实现转跳登录的效果
            // response.sendRedirect(request.getContextPath()+"/login");
            // return false;
            // request.getRequestDispatcher("/login");
            Result fail = Result.fail(ErrorCode.NOT_LOGIN.getCode(), ErrorCode.NOT_LOGIN.getMsg());
            response.setHeader("Content-Type","application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSON(fail));
            return false;
        }

        SysUser sysUser = userService.checkLogin(token);
        if(sysUser == null){
            Result fail = Result.fail(ErrorCode.NOT_LOGIN.getCode(), ErrorCode.NOT_LOGIN.getMsg());
            response.setHeader("Content-Type","application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSON(fail));
            return false;
        }


        return true;
    }
}
