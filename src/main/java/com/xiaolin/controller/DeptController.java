package com.xiaolin.controller;

import com.xiaolin.common.Result;
import com.xiaolin.pojo.Dept;
import com.xiaolin.service.DeptServiceImpl;
import com.xiaolin.service.impl.DeptService;
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
@RequestMapping("/dept")
public class DeptController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/info")
    public Result info(Integer id) {
        return deptService.selectByPrimaryKey(id);
    }


    @GetMapping("/list")
    public Result list() {
        log.info("查询部门列表开始...");
        Result result = deptService.list();
        log.info("查询部门列表结束。data：{}", result.getData());
        return result;
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id) {
        return deptService.deleteByPrimaryKey(id);
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody Dept dept) {
        return deptService.insert(dept);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Dept dept) {
        return deptService.updateByPrimaryKeySelective(dept);
    }
}
