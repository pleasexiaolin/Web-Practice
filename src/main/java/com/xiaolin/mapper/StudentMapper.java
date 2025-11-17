package com.xiaolin.mapper;

import com.xiaolin.pojo.Student;
import com.xiaolin.pojo.query.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lzh
 * @description: 学生模块mapper
 * @date 2025/11/12 10:04
 */
@Mapper
public interface StudentMapper {

    List<Student> page(@Param("condition") StudentQueryParam condition);

    void insert(Student clazz);

    void update( Student clazz);

    void delete(@Param("ids") Integer[] id);

    Student info(Integer id);

    void updateScoureById(@Param("id") Integer id, @Param("score") Integer score, @Param("count") Integer count);

    List<Map> countStudentDegreeData();
}
