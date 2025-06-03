package com.wen.tlias.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wen.tlias.mapper.EmpMapper;
import com.wen.tlias.pojo.Emp;
import com.wen.tlias.service.EmpService;

@Service // 员工管理
public class EmpServiceImpl implements EmpService {
  @Autowired
  private EmpMapper empMapper;

  /**
   * 条件分页查询员工
   * 
   * @param
   * @return
   */
  public List<Emp> getEmpsByMany(Emp emp, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
    Integer pageStart = (page - 1) * pageSize;
    return empMapper.getEmpsByMany(emp, begin, end, pageStart, pageSize);
  }

  /**
   * 获取total
   * 
   * @return total
   */
  public int getTotal(Emp emp, LocalDate begin, LocalDate end) {

    return empMapper.getTotal(emp, begin, end);
  }

  /**
   * 根据ids批量删除员工
   * 
   * @param ids
   */
  public void deleteByIds(Integer[] ids) {
    empMapper.deleteByIds(ids);
  }

  /**
   * 添加员工
   * 
   * @param emp
   */
  public void postEmp(Emp emp) {
    empMapper.postEmp(emp);
  }

  // 根据id查找员工
  public Emp getEmpById(Integer id) {
    return empMapper.getEmpById(id);
  }

  /**
   * 修改员工
   * 
   * @param emp
   */
  public void putEmp(Emp emp) {
    empMapper.putEmp(emp);
  }

  /**
   * 登录功能
   * 
   * @param
   * @return
   */
  public Emp login(Emp emp) {
    return empMapper.getEmpByUsernameAndPassword(emp);
  }
}
