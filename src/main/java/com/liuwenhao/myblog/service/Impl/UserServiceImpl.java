package com.liuwenhao.myblog.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwenhao.myblog.domain.pojo.SysUser;
import com.liuwenhao.myblog.mapper.UserMapper;
import com.liuwenhao.myblog.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {
}
