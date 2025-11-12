package com.xiaolin.controller;

import com.xiaolin.common.Result;
import com.xiaolin.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 统计controller
 */
@RequestMapping("/report")
@RestController
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // 员工职位人数统计
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        return reportService.getEmpJobData();
    }

    // 员工性别统计
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        return reportService.getEmpGenderData();
    }
}
