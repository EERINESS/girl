package com.zzq.domain;

/**
 * @author zzq
 * @createTime 2018/3/12
 * @description http 返回最外层的对象
 */
public class Result<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String message;

    /** 具体的内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
