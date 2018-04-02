package com.zzq.handle;

import com.zzq.domain.Result;
import com.zzq.enums.ResultEnum;
import com.zzq.exception.GirlException;
import com.zzq.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zzq
 * @createTime 2018/3/13
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.info("未知错误");
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR.getCode(), ResultEnum.UNKNOW_ERROR.getMsg());
        }
    }
}
