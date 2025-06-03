package com.wen.tlias.service;

import java.time.LocalDate;
import java.util.List;

import com.wen.tlias.pojo.Emp;

public interface EmpService {

  /**
   * 条件分页查询员工
   * 
   * @param emp
   * @param page
   * @param pageSize
   * @return emp的list
   */
  public List<Emp> getEmpsByMany(Emp emp, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

  /**
   * 计算total
   * 
   * @param
   * @return
   */
  public int getTotal(Emp emp, LocalDate begin, LocalDate end);

  /**
   * 根据ids批量删除员工
   * 
   * @param ids
   */
  public void deleteByIds(Integer[] ids);

  /**
   * 添加员工
   * 
   * @param emp
   */
  public void postEmp(Emp emp);

  // 根据id查找员工
  public Emp getEmpById(Integer id);

  /**
   * 修改员工
   * 
   * @param emp
   */
  public void putEmp(Emp emp);

  /***
   * 登录功能
   * 
   * @param emp
   * @return
   */
  public Emp login(Emp emp);
}
