package com.xiaolin.service.impl;

import com.xiaolin.common.Result;
import com.xiaolin.mapper.EmpMapper;
import com.xiaolin.pojo.JobOption;
import com.xiaolin.service.ReportService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public Result getEmpJobData() {

        List<Map<String, Object>> list = empMapper.countEmpJobData();

        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();

        return Result.success(new JobOption(jobList, dataList));
    }

    @Override
    public Result getEmpGenderData() {
        return Result.success(empMapper.countEmpGenderData());
    }
}
