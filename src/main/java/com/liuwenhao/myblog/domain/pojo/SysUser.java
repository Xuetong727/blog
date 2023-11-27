package com.liuwenhao.myblog.domain.pojo;

import lombok.Data;

@Data
public class SysUser {

    private Long id;

    private String account;

    private int admin;

    private String avatar;

    private Long createDate;

    private int deleted;

    private String email;

    private Long lastLogin;

    private String mobilePhoneNumber;

    private String nickname;

    private String password;

    private String salt;

    private String status;


}
