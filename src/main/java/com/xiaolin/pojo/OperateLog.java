package com.xiaolin.pojo;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author lzh
 * @description: 记录日志
 * @date 2025/11/11 15:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
    private Integer id; //ID
    private String operateEmpName; //操作人ID
    private LocalDateTime operateTime; //操作时间
    private String className; //操作类名
    private String methodName; //操作方法名
    private String methodParams; //操作方法参数
    private String returnValue; //操作方法返回值
    private Long costTime; //操作耗时

    public OperateLog(ProceedingJoinPoint joinPoint, String currentUserName, Object result, long costTime) {
        this.operateEmpName = currentUserName;
        this.operateTime = LocalDateTime.now();
        this.className = joinPoint.getTarget().getClass().getName();
        this.methodName = joinPoint.getSignature().getName();
        this.methodParams = Arrays.toString(joinPoint.getArgs());
        this.returnValue = JSONUtil.toJsonStr(result);
        this.costTime = costTime;
    }
}
