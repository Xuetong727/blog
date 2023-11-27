package com.liuwenhao.myblog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.pojo.SysUser;
import com.liuwenhao.myblog.domain.vo.UserVo;

public interface UserService extends IService<SysUser> {
    SysUser findUser(String account, String pwd);

    Result getUserInfoByToken(String token);

}
