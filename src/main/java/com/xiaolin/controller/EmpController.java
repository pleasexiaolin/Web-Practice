package com.xiaolin.controller;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpQueryParam;
import com.xiaolin.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


/**
 * 员工表(emp)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/emps")
public class EmpController {
    /**
     * 服务对象
     */
    @Resource
    private EmpService empService;


    @GetMapping
    public Result page(EmpQueryParam queryParam) {

        PageResult<Emp> pageResult = empService.page(queryParam);
        return Result.success(pageResult);
    }


}
