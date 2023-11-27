package com.liuwenhao.myblog.service;

import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.vo.param.LoginParam;

public interface LoginService {
    Result login(LoginParam param);

    Result logout(String token);
}
