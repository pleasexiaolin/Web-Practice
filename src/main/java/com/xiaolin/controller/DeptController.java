package com.xiaolin.controller;

import com.xiaolin.common.Result;
import com.xiaolin.pojo.Dept;
import com.xiaolin.service.DeptService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * 部门表(dept)表控制层
 *
 * @author xxxxx
 */
@Slf4j
@RestController
//@RequestMapping("/api")
public class DeptController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list() {
        log.info("查询部门列表开始...");
        Result result = deptService.list();
        log.info("查询部门列表结束。data：{}", result.getData());
        return result;
    }

    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        return deptService.deleteByPrimaryKey(id);
    }

    @PostMapping("/depts")
    public Result insert(@RequestBody Dept dept) {
        return deptService.insert(dept);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept) {
        return deptService.updateByPrimaryKeySelective(dept);
    }
}
