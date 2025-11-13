package com.xiaolin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.mapper.ClazzMapper;
import com.xiaolin.pojo.Clazz;
import com.xiaolin.pojo.query.ClazzQueryParam;
import com.xiaolin.service.ClazzService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lzh
 * @description: 班级服务实现类
 * @date 2025/11/12 9:06
 */
@Slf4j
@Service
public class ClazzServiceImpl implements ClazzService {

    @Resource
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> page(ClazzQueryParam condition) {
        PageHelper.startPage(condition.getPage(), condition.getPageSize());

        List<Clazz> data = clazzMapper.page(condition);

        Page<Clazz> page = (Page<Clazz>) data;
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public Result list() {
        return Result.success(clazzMapper.list());
    }

    @Override
    public Result insert(Clazz clazz) {
        clazzMapper.insert(clazz);
        return Result.success();
    }

    @Override
    public Result delete(Integer id) {
        clazzMapper.delete(id);
        return Result.success();
    }

    @Override
    public Result update(Clazz clazz) {
        clazzMapper.update(clazz);
        return Result.success();
    }

    @Override
    public Result info(Integer id) {
        return Result.success(clazzMapper.info(id));
    }
}
