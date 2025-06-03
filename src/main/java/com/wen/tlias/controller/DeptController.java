package com.wen.tlias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wen.tlias.pojo.Dept;
import com.wen.tlias.pojo.Result;
import com.wen.tlias.service.DeptService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController // 各个层用各个层的bean声明注解
@Slf4j
public class DeptController {
  @Autowired // 注入deptservice对象
  private DeptService deptService;

  // TODO 全部部门列表查询
  @GetMapping("/depts")
  public Result list() {
    log.info("全部部门列表查询");
    // 调用service层方法查询
    List<Dept> deptList = deptService.list();
    return Result.success(deptList); // 用success的重载 传入deptList 返回相应数据
  }

  // TODO 根据id删除部门 需同时删除其下的所有员工
  @DeleteMapping("/depts/{id}")
  public Result deleteDeptById(@PathVariable Integer id) {
    log.info("根据id删除部门");
    deptService.deleteDeptById(id);
    return Result.success();
  }

  // TODO 添加部门 传入部门名字
  @PostMapping("/depts")
  public Result postDept(@RequestBody Dept dept) {
    log.info("添加部门");
    deptService.postDept(dept);
    return Result.success();
  }

  // TODO 根据id查找部门
  @GetMapping("/depts/{id}")
  public Result getDeptById(@PathVariable Integer id) {
    log.info("根据id查找部门");
    Dept dept = deptService.getDeptById(id);
    return Result.success(dept);
  }

  // TODO 修改部门名称
  @PutMapping("/depts")
  public Result putDept(@RequestBody Dept dept) {
    log.info("修改部门");
    deptService.putDept(dept);
    return Result.success();
  }

}
