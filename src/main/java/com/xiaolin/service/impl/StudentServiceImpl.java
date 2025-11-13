package com.xiaolin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.mapper.StudentMapper;
import com.xiaolin.pojo.Student;
import com.xiaolin.pojo.query.StudentQueryParam;
import com.xiaolin.service.StudentService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lzh
 * @description: 学生模块服务实现类
 * @date 2025/11/12 9:59
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentQueryParam condition) {
        PageHelper.startPage(condition.getPage(), condition.getPageSize());
        List<Student> data = studentMapper.page(condition);
        Page<Student> page = (Page<Student>) data;
        return new PageResult<>(page.getTotal(), page.getResult());
    }

    @Override
    public Result insert(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        student.setViolationScore(0);
        student.setViolationCount(0);
        studentMapper.insert(student);
        return Result.success();
    }

    @Override
    public Result delete(Integer[] id) {
        studentMapper.delete(id);
        return Result.success();
    }

    @Override
    public Result update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
        return Result.success();
    }

    @Override
    public Result info(Integer id) {
        return Result.success(studentMapper.info(id));
    }

    @Override
    public Result violation(Integer id, Integer score) {
        studentMapper.updateScoureById(id, score);
        return Result.success();
    }
}
