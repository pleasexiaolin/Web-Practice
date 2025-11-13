package com.xiaolin.pojo.query;

import com.xiaolin.common.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lzh
 * @description: 学生分页查询参数
 * @date 2025/11/12 10:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentQueryParam extends PageQuery {
    private String name;
    private Integer degree;
    private Integer clazzId;
}
