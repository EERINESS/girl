package com.zzq.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zzq
 * @createTime 2018/3/13
 */
//切面类注解
@Aspect
//将此文件引入到 spring 容器中
@Component
public class HttpAspect {
    // 日志打印
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * execution(public * com.zzq.controller.GirlController.*(..)) 表示拦截此类的所有方法及所有参数，
     * 也可拦截指定方法 execution(public * com.zzq.controller.GirlController.girlList(..))
     * 公用方法 log(), 注解使用 @Pointcut 意思为要切那个点，后面要切入同样点的可以直接写 log(), 以免代码重复，修改繁琐
     */
    @Pointcut("execution(public * com.zzq.controller.GirlController.*(..))")
    public void log(){}

    // 在 http 请求之前到这个方法
    @Before("log()")
    public void deBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        //url
        logger.info("url = {}", request.getRequestURI());

        //method
        logger.info("method = {}", request.getMethod());

        //ip
        logger.info("ip = {}", request.getRemoteAddr());

        //类方法
        logger.info("class_method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("ages = {}", joinPoint.getArgs());
    }

    /**
     * 在 http 请求之后到这个方法
     * 如果是拦截不同的类方法，可以直接 @After("execution(public * com.zzq.controller.GirlController.*(..))") 这样写
     */
    @After("log()")
    public void deAfter(){
        logger.info("after : 222222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response = {}", object.toString());
    }

}
