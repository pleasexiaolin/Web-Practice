package com.xiaolin.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lzh
 * @description: 耗时切面
 * @date 2025/11/11 14:00
 */
@Slf4j
@Aspect
@Component
public class RecordTimeAspect {

    // 切入点表达式一 自由匹配 execution(访问修饰符?  返回值  包名.类名.?方法名(方法参数) throws 异常?)
    //@Pointcut("execution(* com.xiaolin.service.DeptService.*(..))")
    //private void pointcut(){}

    // 切入点表达式二 自定义注解
    @Pointcut("@annotation(com.xiaolin.aop.RecordTimeCall)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        //记录方法执行开始时间
        long begin = System.currentTimeMillis();

        //执行原始方法
        Object result = pjp.proceed();

        //记录方法执行结束时间
        long end = System.currentTimeMillis();

        //计算方法执行耗时
        log.info("方法执行耗时: {}毫秒",end-begin);
        return result;
    }
}
