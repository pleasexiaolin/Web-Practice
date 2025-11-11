package com.xiaolin.mapper;

import com.xiaolin.pojo.LogQueryParam;
import com.xiaolin.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lzh
 * @description: 记录日志mapper
 * @date 2025/11/11 15:29
 */
@Mapper
public interface OperateLogMapper {

    void insert(OperateLog log);

    List<OperateLog> list(@Param("condition") LogQueryParam condition);
}
