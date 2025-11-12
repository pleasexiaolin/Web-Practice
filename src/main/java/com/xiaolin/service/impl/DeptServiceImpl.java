package com.xiaolin.service.impl;

import com.xiaolin.aop.LogCall;
import com.xiaolin.common.Result;
import com.xiaolin.mapper.DeptMapper;
import com.xiaolin.mapper.EmpMapper;
import com.xiaolin.pojo.Dept;
import com.xiaolin.pojo.Emp;
import com.xiaolin.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Resource
    private EmpMapper empMapper;

    @Override
    @LogCall
    public Result delete(Integer id) {

        // 判断是否有员工是要删除的部门下的
        List<Emp> emps = empMapper.getDeptEmpList(id);

        if (!CollectionUtils.isEmpty(emps)){
            return Result.error("该部门下还有员工，无法删除。请修改员工信息后再操作！");
        }

        deptMapper.delete(id);
        return Result.success();
    }

    @Override
    @LogCall
    public Result insert(Dept record) {
        deptMapper.insert(record);
        return Result.success();
    }

    @Override
    @LogCall
    public Result update(Dept record) {
        record.setUpdateTime(LocalDateTime.now());
        deptMapper.update(record);
        return Result.success();
    }

    @Override
    public Result list() {
        List<Dept> data = deptMapper.list();
        return Result.success(data);
    }

}
