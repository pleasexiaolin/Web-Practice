package com.xiaolin.controller;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpQueryParam;
import com.xiaolin.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


/**
 * 员工模块controller
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Resource
    private EmpService empService;

    /**
     * 新增员工
     *
     * @param emp 员工信息
     * @return 成功 失败
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {return empService.insert(emp);}
    /**
     * 删除员工
     *
     * @param ids 主键id
     * @return 成功 失败
     */
    @DeleteMapping
    private Result deleteEmp(Integer[] ids) {return empService.delete(ids);}
    /**
     * 修改员工
     *
     * @param emp 员工数据
     * @return 成功 失败
     */
    @PutMapping
    private Result update(@RequestBody Emp emp) {return empService.update(emp);}
    /**
     * 员工详情（回显）
     *
     * @param id 主键
     * @return 详情信息
     */
    @GetMapping("/{id}")
    private Result info(@PathVariable Integer id) {return empService.info(id);}
    /**
     * 分页查询员工
     *
     * @param condition 查询参数
     * @return 分页结果
     */
    @GetMapping
    public Result page(EmpQueryParam condition) {
        PageResult<Emp> pageResult = empService.page(condition);
        return Result.success(pageResult);
    }
}
