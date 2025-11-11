package com.xiaolin.common;

import lombok.Setter;

import java.util.Objects;

/**
 * @author lzh
 * @description: 分页查询类
 * @date 2025/11/11 16:05
 */
@Setter
public class PageQuery {
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 当前页面
     */
    private Integer page;

    public Integer getPageSize() {
        if (Objects.isNull(pageSize)) {
            return 10;
        }
        return pageSize;
    }

    public Integer getPage() {
        if (Objects.isNull(page)) {
            return 1;
        }
        return page;
    }

}
