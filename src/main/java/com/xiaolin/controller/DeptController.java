package com.xiaolin.controller;

import com.xiaolin.common.Result;
import com.xiaolin.pojo.Dept;
import com.xiaolin.service.DeptService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * 部门模块controller
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 新增部门
     *
     * @param dept 实体
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        return deptService.insert(dept);
    }

    /**
     * 删除部门
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result delete(Integer id) {
        return deptService.delete(id);
    }

    /**
     * 修改部门
     *
     * @param dept 实体
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        return deptService.update(dept);
    }

    /**
     * 查询所以部门数据
     *
     * @return 所有数据
     */
    @GetMapping
    public Result list() {
        return deptService.list();
    }
}
