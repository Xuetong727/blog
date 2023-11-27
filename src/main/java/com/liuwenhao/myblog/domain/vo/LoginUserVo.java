package com.liuwenhao.myblog.domain.vo;

import lombok.Data;

@Data
public class LoginUserVo {

    private Long id;

    private String account;

    private String avatar;

    private String nickname;
}
