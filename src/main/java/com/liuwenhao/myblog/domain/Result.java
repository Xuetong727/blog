package com.liuwenhao.myblog.domain;

import com.liuwenhao.myblog.common.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private boolean success;
    private int code;
    private String msg;
    private Object data;

    public static Result success(Object data){
        return new Result(true, Constant.SUCCESS,"success",data);
    }

    public static Result success(){
        return new Result(true, Constant.SUCCESS,"success",null);
    }

    public static Result fail(Integer code, String msg){
        return new Result(false,code,msg,null);

    }
}
