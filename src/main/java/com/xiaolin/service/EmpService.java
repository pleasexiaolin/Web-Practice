package com.xiaolin.service;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpQueryParam;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam condition);

    Result insert(Emp emp);

    Result delete(Integer[] ids);

    Result info(Integer id);

    Result update(Emp emp);

    Result login(Emp emp);

    Result list();
}

