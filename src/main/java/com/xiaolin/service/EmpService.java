package com.xiaolin.service;


import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Emp;
import com.xiaolin.pojo.EmpQueryParam;

public interface EmpService {

    /**
     * 分页查询
     *
     * @param queryParam 查询参数
     * @return 分页数据
     */
    PageResult<Emp> page(EmpQueryParam queryParam);

    /**
     * 新增
     *
     * @param emp
     * @return
     */
    Result save(Emp emp);


    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    Result remove(Integer[] ids);

    /**
     * 详情
     * @param id
     * @return
     */
    Result info(Integer id);

    /**
     * 修改
     * @param emp
     * @return
     */
    Result update(Emp emp);
}

