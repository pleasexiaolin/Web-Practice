package com.xiaolin.mapper;

import com.xiaolin.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    int insert(Dept record);

    int delete(Integer id);

    int update(Dept record);

    List<Dept> list();
}