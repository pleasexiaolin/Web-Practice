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
@RequestMapping("/depts")
public class DeptController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;

    /**
     * 查询所有部门数据
     *
     * @return 所有数据
     */
    @GetMapping
    public Result list() {
        return deptService.list();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public Result delete(Integer id) {
        return deptService.deleteByPrimaryKey(id);
    }

    /**
     * 新增数据
     *
     * @param dept 实体
     * @return 新增结果
     */
    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        return deptService.insert(dept);
    }

    /**
     * 修改数据
     *
     * @param dept 实体
     * @return 修改结果
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        return deptService.updateByPrimaryKeySelective(dept);
    }
}
