package com.limbo.search.config;

import com.limbo.search.sys.service.UserService;
import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * describe: 方法执行监控
 * current user Maochao.zhu
 * current system 2020/7/3
 * @author King.LF
 */
@Component
@Aspect
public class ExpendAdvice {
    public Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    UserService userService;
    @Pointcut("execution(* com.limbo.search.*.service.impl.*.*(..))")
    private void aspectjMethod() {
    }

    @Around("aspectjMethod()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            String method = joinPoint.getSignature().getName();
            long st = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long diff = System.currentTimeMillis() - st;
            if((method.indexOf("insert") != -1 || method.indexOf("delete") != -1 ||method.indexOf("update") != -1) && method.indexOf("insertLog")==-1){
                String content= "基础模块调用方法："+method+"，传递参数："+new Gson().toJson(joinPoint.getArgs())+"，耗时："+diff+" ms";
                userService.insertLog(content);
            } else if(method.indexOf("list") != -1){
                String content= "查询模块调用方法："+method+"，传递参数："+new Gson().toJson(joinPoint.getArgs())+"，耗时："+diff+" ms";
                userService.insertLog(content);
            }
            return result;
        } catch (Throwable throwable) {
            logger.error("环绕增强发生异常");
            logger.error(throwable.getMessage(), throwable.getStackTrace());
            throw throwable;
        }
    }
}
