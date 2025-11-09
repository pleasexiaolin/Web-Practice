package com.xiaolin.mapper;

import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    List<Emp> list(EmpQueryParam queryParam);

    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
    Long count();
}