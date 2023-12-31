package com.liuwenhao.myblog.service.Impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwenhao.myblog.common.ErrorCode;
import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.pojo.SysUser;
import com.liuwenhao.myblog.domain.vo.LoginUserVo;
import com.liuwenhao.myblog.domain.vo.UserVo;
import com.liuwenhao.myblog.mapper.UserMapper;
import com.liuwenhao.myblog.service.UserService;
import com.liuwenhao.myblog.utils.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public SysUser findUser(String account, String pwd) {

        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getAccount,account);
        lambdaQueryWrapper.eq(SysUser::getPassword,pwd);
        lambdaQueryWrapper.select(SysUser::getId,SysUser::getAccount,SysUser::getAvatar,SysUser::getNickname);
        SysUser one = getOne(lambdaQueryWrapper);
        return one;
    }

    @Override
    public Result getUserInfoByToken(String token) {
        SysUser sysUser = checkLogin(token);
        if (sysUser == null){
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        BeanUtils.copyProperties(sysUser,loginUserVo);
        return Result.success(loginUserVo);
    }

    @Override
    public SysUser checkLogin(String token) {

        Map<String, Object> map = JWTUtils.checkToken(token);
        if(map == null){
            return null;
        }
        //获取用户信息 -
        String userJson = (String) redisTemplate.opsForValue().get("TOKEN_" + token);
        if(StringUtils.isBlank(userJson)){
            return null;
        }
        return JSON.parseObject(userJson, SysUser.class);
    }
}
