package com.xiaolin.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 报表
 */
@Data
@NoArgsConstructor
public class JobOption {
    // 职位
    private List<Object> jobList;
    // 数据
    private List<Object> dataList;

    public JobOption(List<Object> jobList, List<Object> dataList) {
        this.jobList = jobList;
        this.dataList = dataList;
    }
}
