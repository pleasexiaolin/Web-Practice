package com.xiaolin.service;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Student;
import com.xiaolin.pojo.query.StudentQueryParam;

/**
 * @author lzh
 * @description: 学生模块服务
 * @date 2025/11/12 9:58
 */
public interface StudentService {

    PageResult<Student> page(StudentQueryParam condition);

    Result insert(Student student);

    Result delete(Integer[] id);

    Result update(Student student);

    Result info(Integer id);

    // 违纪处理
    Result violation(Integer id, Integer score);
}
