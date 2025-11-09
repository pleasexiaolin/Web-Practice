package com.xiaolin.service;

import com.xiaolin.common.Result;
import com.xiaolin.pojo.Dept;

public interface DeptService {

    Result deleteByPrimaryKey(Integer id);

    Result insert(Dept record);

    int insertSelective(Dept record);

    Result selectByPrimaryKey(Integer id);

    Result updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    Result list();
}
