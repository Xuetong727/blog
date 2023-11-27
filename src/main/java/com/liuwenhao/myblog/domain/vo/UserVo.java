package com.liuwenhao.myblog.domain.vo;

import lombok.Data;

@Data
public class UserVo {

    private Long id;

    private String account;

    private Boolean admin;

    private String avatar;

    private Long createDate;

    private Boolean deleted;

    private String email;

    private Long last_login;

    private String mobilePhoneNumber;

    private String nickname;

    private String password;

    private String salt;

    private String status;


}
