package com.xiaolin.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaolin.aop.LogCall;
import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.mapper.EmpMapper;
import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpExpr;
import com.xiaolin.pojo.EmpQueryParam;
import com.xiaolin.pojo.LoginInfo;
import com.xiaolin.service.EmpService;
import com.xiaolin.utils.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    @LogCall
    public PageResult<Emp> page(EmpQueryParam condition) {
        // PageHelper形式分页
        //1. 设置PageHelper分页参数
        PageHelper.startPage(condition.getPage(), condition.getPageSize());
        //2. 执行查询
        List<Emp> empList = empMapper.listEmp(condition);
        //3. 封装分页结果
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<>(p.getTotal(), p.getResult());

        // mybatis plus 分页
        //return empMapper.listEmp(condition, page);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result insert(Emp emp) {
        //1.补全基础属性
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        emp.setPassword("123456");

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
    public Result delete(Integer[] ids) {
        empMapper.deleteEmp(ids);
        empMapper.deleteExpr(ids);
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

    @Override
    public Result login(Emp emp) {
        Emp loginEmp = empMapper.getUserInfo(emp);

        if (loginEmp != null) {
            Map<String, Object> dataMap = new HashMap<>();

            dataMap.put("id", loginEmp.getId());
            dataMap.put("username", loginEmp.getUsername());
            dataMap.put("name", loginEmp.getName());

            // 生成令牌
            String token = JwtUtil.generateJwt(dataMap);
            LoginInfo loginInfo = new LoginInfo(loginEmp.getId(), loginEmp.getUsername(), loginEmp.getName(), token);
            System.out.println(loginInfo);
            return Result.success(loginInfo);
        }

        return null;
    }

}
