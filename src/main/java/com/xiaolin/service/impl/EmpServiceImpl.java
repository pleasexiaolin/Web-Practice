package com.xiaolin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.EmpQueryParam;
import com.xiaolin.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xiaolin.pojo.Emp;
import com.xiaolin.mapper.EmpMapper;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return empMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Emp record) {
        return empMapper.insert(record);
    }

    @Override
    public int insertSelective(Emp record) {
        return empMapper.insertSelective(record);
    }

    @Override
    public Emp selectByPrimaryKey(Integer id) {
        return empMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Emp record) {
        return empMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Emp record) {
        return empMapper.updateByPrimaryKey(record);
    }


    @Override
    public PageResult<Emp> page(EmpQueryParam queryParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        //2. 执行查询
        List<Emp> empList = empMapper.list(queryParam);
        //3. 封装分页结果
        Page<Emp> p = (Page<Emp>)empList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

}
