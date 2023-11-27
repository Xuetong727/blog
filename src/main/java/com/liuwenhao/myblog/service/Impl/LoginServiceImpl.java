package com.liuwenhao.myblog.service.Impl;

import com.alibaba.fastjson.JSON;
import com.liuwenhao.myblog.common.ErrorCode;
import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.pojo.SysUser;
import com.liuwenhao.myblog.domain.pojo.Tag;
import com.liuwenhao.myblog.domain.vo.param.LoginParam;
import com.liuwenhao.myblog.service.LoginService;

import com.liuwenhao.myblog.service.UserService;
import com.liuwenhao.myblog.utils.JWTUtils;
import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    private static final String salt = "liuwenhao";

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Result login(LoginParam param) {
        String account = param.getAccount();

        String password = param.getPassword();

        if(StringUtils.isBlank(account)  || StringUtils.isBlank(password)){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }

        String pwd = DigestUtils.md5Hex(password + salt);

        SysUser user = userService.findUser(account,pwd);

        if(user == null){
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(user.getId());
        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(user),1, TimeUnit.DAYS);
        return Result.success(token);
    }

    @Override
    public Result logout(String token) {
        // Map<String, Object> map = JWTUtils.checkToken(token);
        // if(map == null){
        //     return Result.fail(ErrorCode.NOT_LOGIN.getCode(), ErrorCode.NOT_LOGIN.getMsg());
        // }
        redisTemplate.delete("TOKEN_"+token);
        return Result.success(null);
    }
}
