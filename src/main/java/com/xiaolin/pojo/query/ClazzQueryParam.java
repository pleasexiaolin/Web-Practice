package com.xiaolin.pojo.query;

import com.xiaolin.common.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lzh
 * @description: 班级查询请求
 * @date 2025/11/12 9:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ClazzQueryParam extends PageQuery {
    private String name;// 班级名称
    private String begin;// 开课时间
    private String end;// 结束时间
    private Integer masterId; //班主任
    private Integer subject; //学科
}
