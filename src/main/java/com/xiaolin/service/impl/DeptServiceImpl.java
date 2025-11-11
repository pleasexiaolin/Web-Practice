package com.xiaolin.service.impl;

import com.xiaolin.common.Result;
import com.xiaolin.mapper.DeptMapper;
import com.xiaolin.pojo.Dept;
import com.xiaolin.service.DeptService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptMapper deptMapper;

    @Override
    public Result delete(Integer id) {
        deptMapper.delete(id);
        return Result.success();
    }

    @Override
    public Result insert(Dept record) {
        deptMapper.insert(record);
        return Result.success();
    }

    @Override
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
