package com.xiaolin.aop;

import com.xiaolin.pojo.OperateLog;
import com.xiaolin.service.LogService;
import com.xiaolin.utils.CurrentHolderUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lzh
 * @description: 日志切面
 * @date 2025/11/11 16:44
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    private final LogService logService;

    public LogAspect(LogService logService) {
        this.logService = logService;
    }

    @Pointcut("@annotation(com.xiaolin.aop.LogCall)")
    public void pointcut() {
    }

    @Around("pointcut() && @annotation(log)")
    public Object around(ProceedingJoinPoint joinPoint, LogCall log) throws Throwable {
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        // 执行方法
        Object result = joinPoint.proceed();
        // 当前时间
        long endTime = System.currentTimeMillis();
        // 构建日志对象
        try {
            logService.inert(new OperateLog(joinPoint, getCurrentUserName(), result, (endTime - startTime)));
        } catch (Exception e) {
            LogAspect.log.error("日志记录异常", e);
        }

        return result;
    }

    // 获取当前用户姓名
    private String getCurrentUserName() {
        return CurrentHolderUtil.getCurrentUser();
    }
}
