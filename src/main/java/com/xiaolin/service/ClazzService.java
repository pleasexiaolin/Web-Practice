package com.xiaolin.service;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Clazz;
import com.xiaolin.pojo.query.ClazzQueryParam;

/**
 * @author lzh
 * @description: 班级服务
 * @date 2025/11/12 9:06
 */
public interface ClazzService {

    PageResult<Clazz> page(ClazzQueryParam condition);

    Result list();

    Result insert(Clazz clazz);

    Result delete(Integer id);

    Result update(Clazz clazz);

    Result info(Integer id);
}
