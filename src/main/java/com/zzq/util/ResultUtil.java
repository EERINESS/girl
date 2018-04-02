package com.zzq.util;

import com.zzq.domain.Result;
import com.zzq.enums.ResultEnum;

/**
 * @author zzq
 * @createTime 2018/3/12
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}
