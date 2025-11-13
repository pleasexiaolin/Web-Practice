package com.xiaolin.service.impl;

import com.xiaolin.common.Result;
import com.xiaolin.mapper.ClazzMapper;
import com.xiaolin.mapper.EmpMapper;
import com.xiaolin.mapper.StudentMapper;
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

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private ClazzMapper clazzMapper;

    @Override
    public Result getEmpJobData() {

        List<Map<String, Object>> list = empMapper.countEmpJobData();

        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();

        return Result.success(new JobOption(jobList, dataList,"job"));
    }

    @Override
    public Result getEmpGenderData() {
        return Result.success(empMapper.countEmpGenderData());
    }

    @Override
    public Result getStudentDegreeData() {

        return Result.success( studentMapper.countStudentDegreeData());
    }

    @Override
    public Result getStudentCountData() {
        List<Map<String, Object>> list = clazzMapper.countStudentCountData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return Result.success(new JobOption(jobList, dataList,"student"));
    }
}
