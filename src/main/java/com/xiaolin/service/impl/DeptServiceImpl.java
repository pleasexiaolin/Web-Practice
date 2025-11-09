package com.xiaolin.service.impl;

import com.xiaolin.common.Result;
import com.xiaolin.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xiaolin.mapper.DeptMapper;
import com.xiaolin.pojo.Dept;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public Result deleteByPrimaryKey(Integer id) {
        deptMapper.deleteByPrimaryKey(id);
        return Result.success();
    }

    @Override
    public Result insert(Dept record) {
        deptMapper.insert(record);
        return Result.success();
    }

    @Override
    public int insertSelective(Dept record) {
        return deptMapper.insertSelective(record);
    }

    @Override
    public Result selectByPrimaryKey(Integer id) {
        return Result.success(deptMapper.selectByPrimaryKey(id));
    }

    @Override
    public Result updateByPrimaryKeySelective(Dept record) {
        record.setUpdateTime(LocalDateTime.now());
        deptMapper.updateByPrimaryKeySelective(record);
        return Result.success();
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return deptMapper.updateByPrimaryKey(record);
    }

    @Override
    public Result list() {
        List<Dept> data = deptMapper.list();
        return Result.success(data);
    }

}
