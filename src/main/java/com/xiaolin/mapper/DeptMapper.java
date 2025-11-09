package com.xiaolin.mapper;

import com.xiaolin.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int updateByPrimaryKeySelective(Dept record);

    List<Dept> list();

}