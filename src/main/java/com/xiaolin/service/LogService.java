package com.xiaolin.service;

import com.xiaolin.common.PageResult;
import com.xiaolin.pojo.LogQueryParam;
import com.xiaolin.pojo.OperateLog;

/**
 * @author lzh
 * @description: 日志服务
 * @date 2025/11/11 15:36
 */
public interface LogService {

    void inert(OperateLog log);

    PageResult<OperateLog> list(LogQueryParam condition);
}
