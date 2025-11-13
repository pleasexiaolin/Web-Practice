package com.xiaolin.mapper;

import com.xiaolin.pojo.Clazz;
import com.xiaolin.pojo.query.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lzh
 * @description: 班级mapper
 * @date 2025/11/12 9:27
 */
@Mapper
public interface ClazzMapper {

    List<Clazz> page(@Param("condition") ClazzQueryParam condition);

    void insert(Clazz clazz);

    void update(Clazz clazz);

    void delete(Integer id);

    Clazz info(Integer id);

    List<Clazz> list();

    List<Map<String, Object>> countStudentCountData();
}
