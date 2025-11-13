package com.xiaolin.controller;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Clazz;
import com.xiaolin.pojo.query.ClazzQueryParam;
import com.xiaolin.service.ClazzService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzh
 * @description: 班级controller
 * @date 2025/11/12 9:05
 */
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Resource
    private ClazzService clazzService;


    // 分页
    @GetMapping
    public Result page(ClazzQueryParam condition) {
        PageResult<Clazz> page = clazzService.page(condition);
        return Result.success(page);
    }

    // 删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return clazzService.delete(id);
    }

    // 新增
    @PostMapping
    public Result insert(@RequestBody Clazz clazz) {
        return clazzService.insert(clazz);
    }

    //详情
    @GetMapping("{id}")
    public Result info(@PathVariable Integer id) {
        return clazzService.info(id);
    }

    // 修改
    @PutMapping
    private Result update(@RequestBody Clazz clazz) {
        return clazzService.update(clazz);
    }

    // 查询全部班级
    @GetMapping("/list")
    public Result list() {
        return clazzService.list();
    }


}
