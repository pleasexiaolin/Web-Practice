package com.xiaolin.service;

import com.xiaolin.common.Result;
import com.xiaolin.pojo.Dept;

public interface DeptService {

    Result delete(Integer id);

    Result insert(Dept record);

    Result update(Dept record);

    Result list();
}
