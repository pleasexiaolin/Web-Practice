package com.xiaolin.pojo;

import com.xiaolin.common.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lzh
 * @description: 日志分页请求参数
 * @date 2025/11/11 15:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LogQueryParam extends PageQuery {
    private Integer operateEmpName; //操作人ID
    private Long costTimeFrom; //操作耗时起
    private Long costTimeTo; //操作耗时止
}
