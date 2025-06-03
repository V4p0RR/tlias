package com.wen.tlias.service;

import java.util.List;

import com.wen.tlias.pojo.Dept;

public interface DeptService {
  /**
   * 查询全部部门
   * 
   * @return
   */
  public List<Dept> list();

  /**
   * 根据id删除部门
   * 
   * @param id
   */
  public void deleteDeptById(Integer id);

  /**
   * 新增部门
   * 
   * @param dept
   */
  public void postDept(Dept dept);

  /**
   * 根据id查找部门
   * 
   * @return dept
   * @param id
   */
  public Dept getDeptById(Integer id);

  /***
   * 修改部门
   * 
   * @param dept
   */
  public void putDept(Dept dept);

}
