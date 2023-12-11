package com.liuwenhao.myblog.handler;


import com.liuwenhao.myblog.common.ErrorCode;
import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.utils.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        String[] tokenS = authorization.split("TOKEN_");
        if(tokenS.length == 0){
            response.sendRedirect(request.getContextPath()+"/login");
        }
        String token = tokenS[0];
        if(StringUtils.isBlank(token))
        {
            response.sendRedirect(request.getContextPath()+"/login");
        }
        Map<String, Object> map = JWTUtils.checkToken(token);
        if(map == null){
            response.sendRedirect(request.getContextPath()+"/login");
        }
        String userJson = (String) redisTemplate.opsForValue().get("TOKEN_" + token);
        if(StringUtils.isBlank(userJson)){
            response.sendRedirect(request.getContextPath()+"/login");
        }
        return true;
    }
}
