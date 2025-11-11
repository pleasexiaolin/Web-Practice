package com.xiaolin.controller;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.LogQueryParam;
import com.xiaolin.pojo.OperateLog;
import com.xiaolin.service.EmpService;
import com.xiaolin.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzh
 * @description: 登录controller
 * @date 2025/11/11 8:18
 */
@Slf4j
@RestController
public class LoginController {

    private final EmpService empService;

    private final LogService logService;

    public LoginController(EmpService empService, LogService logService) {
        this.empService = empService;
        this.logService = logService;
    }

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        if (StringUtils.isEmpty(emp.getUsername()) || StringUtils.isEmpty(emp.getPassword())) {
            return Result.error("用户名或密码为空！");
        }
        return empService.login(emp);
    }

    @GetMapping("/log")
    public PageResult<OperateLog> log(LogQueryParam condition) {
        return logService.list(condition);
    }

}
