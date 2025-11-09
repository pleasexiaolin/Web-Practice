package com.xiaolin.service;

import com.xiaolin.common.Result;
import com.xiaolin.pojo.Dept;

public interface DeptService {

    Result deleteByPrimaryKey(Integer id);

    Result insert(Dept record);

    Result updateByPrimaryKeySelective(Dept record);

    Result list();
}
