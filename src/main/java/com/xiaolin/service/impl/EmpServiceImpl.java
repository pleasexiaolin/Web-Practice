package com.xiaolin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.mapper.EmpMapper;
import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpExpr;
import com.xiaolin.pojo.EmpQueryParam;
import com.xiaolin.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(EmpQueryParam queryParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        //2. 执行查询
        List<Emp> empList = empMapper.listEmp(queryParam);
        //3. 封装分页结果
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result save(Emp emp) {
        //1.补全基础属性
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        // 2.新增员工
        empMapper.insertEmp(emp);

        //3. 保存员工的工作经历信息 - 批量
        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(empId));
            empMapper.insertExprBatch(exprList);
        }

        return Result.success(empId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result remove(Integer[] ids) {
        empMapper.removeEmp(ids);
        empMapper.removeExpr(ids);
        return Result.success();
    }

    @Override
    public Result info(Integer id) {
        // 员工信息
        Emp emp = empMapper.info(id);
        // 工作经历
        List<EmpExpr> empExprList = empMapper.listExpr(id);
        emp.setExprList(empExprList);

        return Result.success(emp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(Emp emp) {
        empMapper.updateEmp(emp);
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empMapper.updateExpr(empExpr));
        }
        return Result.success();
    }

}
