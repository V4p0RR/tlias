package com.wen.tlias.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.wen.tlias.pojo.Emp;
import com.wen.tlias.pojo.PageBean;
import com.wen.tlias.pojo.Result;
import com.wen.tlias.service.EmpService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@Slf4j
public class EmpController {
  @Autowired
  private EmpService empService;

  // TODO 条件分页查询员工
  @GetMapping("/emps")
  public Result getEmpsByMany(Emp emp, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
    log.info("条件分页查询员工");
    List<Emp> emps = empService.getEmpsByMany(emp, begin, end, page, pageSize);
    int total = empService.getTotal(emp, begin, end);
    PageBean pageBean = new PageBean(total, emps); // 封装在实体类中
    return Result.success(pageBean);
  }

  // TODO 根据id批量删除员工
  @DeleteMapping("emps/{ids}")
  public Result deleteByIds(@PathVariable Integer[] ids) {
    log.info("根据ids批量删除员工");
    empService.deleteByIds(ids);
    return Result.success();
  }

  // TOOD 添加员工
  @PostMapping("/emps")
  public Result postEmp(@RequestBody Emp emp) {
    log.info("添加员工");
    empService.postEmp(emp);
    return Result.success();
  }

  // TODO 根据id查询员工
  @GetMapping("/emps/{id}")
  public Result getEmpById(@PathVariable Integer id) {
    log.info("根据id查询员工");
    return Result.success(empService.getEmpById(id));
  }

  // TODO 修改员工
  @PutMapping("/emps")
  public Result putEmp(@RequestBody Emp emp) {
    log.info("修改员工");
    empService.putEmp(emp);
    return Result.success();
  }

  // TODO 文件上传

}
