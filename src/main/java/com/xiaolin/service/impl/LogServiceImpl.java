package com.xiaolin.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaolin.common.PageResult;
import com.xiaolin.mapper.OperateLogMapper;
import com.xiaolin.pojo.LogQueryParam;
import com.xiaolin.pojo.OperateLog;
import com.xiaolin.service.LogService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzh
 * @description: 日志实现
 * @date 2025/11/11 15:37
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private OperateLogMapper logMapper;

    @Override
    public void inert(OperateLog log) {
        logMapper.insert(log);
    }

    @Override
    public PageResult<OperateLog> list(LogQueryParam condition) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(condition.getPage(), condition.getPageSize());
        //2. 执行查询
        List<OperateLog> empList = logMapper.list(condition);
        //3. 封装分页结果
        Page<OperateLog> p = (Page<OperateLog>) empList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
