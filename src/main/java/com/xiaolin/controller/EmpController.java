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
     * @param queryParam 查询参数
     * @return 分页结果
     */
    @GetMapping
    public Result page(EmpQueryParam queryParam) {
        PageResult<Emp> pageResult = empService.page(queryParam);
        return Result.success(pageResult);
    }

    /**
     * 添加员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        return empService.save(emp);
    }

    /**
     * 删除员工
     * @param ids
     * @return
     */
    @DeleteMapping
    private Result deleteEmp(Integer[] ids){

        return empService.remove(ids);
    }

    /**
     * 员工详情
     * @param id
     * @return
     */
    @GetMapping("/info")
    private Result info(Integer id){
        return empService.info(id);
    }

    /**
     * 员工详情
     * @param emp
     * @return
     */
    @PutMapping
    private Result update(Emp emp){

        return empService.update(emp);
    }

}
