package com.xiaolin.controller;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpQueryParam;
import com.xiaolin.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


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

    /**
     * 分页查询
     *
     * @param condition 查询参数
     * @return 分页结果
     */
    @GetMapping
    public Result page(EmpQueryParam condition) {
        PageResult<Emp> pageResult = empService.page(condition);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        return empService.save(emp);
    }

    /**
     * 删除员工
     *
     * @param ids 主键id
     * @return 删除结果
     */
    @DeleteMapping
    private Result deleteEmp(Integer[] ids) {

        return empService.remove(ids);
    }

    /**
     * 员工详情
     *
     * @param id 主键
     * @return 详情信息
     */
    @GetMapping("/info")
    private Result info(Integer id) {
        return empService.info(id);
    }

    /**
     * 员工详情
     *
     * @param emp 员工信息
     * @return 修改结果
     */
    @PutMapping
    private Result update(Emp emp) {

        return empService.update(emp);
    }

}
