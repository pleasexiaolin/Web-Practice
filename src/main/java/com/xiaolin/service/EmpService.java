package com.xiaolin.service;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpQueryParam;

import java.time.LocalDate;

public interface EmpService {


    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    PageResult<Emp>  page(EmpQueryParam queryParam);
}

