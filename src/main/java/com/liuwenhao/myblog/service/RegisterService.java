package com.liuwenhao.myblog.service;

import com.liuwenhao.myblog.domain.Result;
import com.liuwenhao.myblog.domain.vo.param.RegisterParam;

public interface RegisterService {
    Result register(RegisterParam param);
}
