package com.xiaolin.aop;

import cn.hutool.json.JSONUtil;
import com.xiaolin.pojo.OperateLog;
import com.xiaolin.service.LogService;
import com.xiaolin.utils.CurrentHolderUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author lzh
 * @description: 日志切面
 * @date 2025/11/11 16:44
 */
@Aspect
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
        // 耗时
        long costTime = endTime - startTime;

        // 构建日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpName(getCurrentUserName());
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(JSONUtil.toJsonStr(result));
        operateLog.setCostTime(costTime);

        logService.inert(operateLog);
        return result;
    }

    // 获取当前用户姓名
    private String getCurrentUserName() {
        return CurrentHolderUtil.getCurrentUser();
    }
}
