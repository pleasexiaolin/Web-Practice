package com.xiaolin.controller;

import com.xiaolin.common.PageResult;
import com.xiaolin.common.Result;
import com.xiaolin.pojo.Student;
import com.xiaolin.pojo.query.StudentQueryParam;
import com.xiaolin.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author lzh
 * @description: 学生controller
 * @date 2025/11/12 9:05
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam condition) {
        PageResult<Student> page = studentService.page(condition);
        return Result.success(page);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable Integer[] ids) {
        return studentService.delete(ids);
    }

    @PostMapping
    public Result insert(@RequestBody Student student) {
        return studentService.insert(student);
    }

    @GetMapping("/{id}")
    public Result info(@PathVariable Integer id) {
        return studentService.info(id);
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        return studentService.violation(id, score);
    }
}
