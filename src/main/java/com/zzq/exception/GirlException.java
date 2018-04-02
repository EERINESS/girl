package com.zzq.exception;

import com.zzq.enums.ResultEnum;

/**
 * @author zzq
 * @createTime 2018/3/13
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException (ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
