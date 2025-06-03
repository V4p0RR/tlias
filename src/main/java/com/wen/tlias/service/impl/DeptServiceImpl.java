package com.wen.tlias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wen.tlias.mapper.DeptMapper;
import com.wen.tlias.mapper.EmpMapper;
import com.wen.tlias.pojo.Dept;
import com.wen.tlias.service.DeptService;

@Service // 部门管理
public class DeptServiceImpl implements DeptService {
  @Autowired // 注入deptmapper对象
  private DeptMapper deptMapper;
  @Autowired
  private EmpMapper empMapper;

  /**
   * 查询全部部门
   * 
   * @return
   */
  public List<Dept> list() {

    return deptMapper.list();
  }

  /**
   * 根据id删除部门
   * 
   * @return
   * @param id
   */
  @Transactional(rollbackFor = Exception.class) // 事务管理 所有异常都回滚
  public void deleteDeptById(Integer id) {
    deptMapper.deleteDeptById(id);
    // 同时删除其下的员工
    // int i = 1 / 0; 测试事务回滚
    empMapper.deleteEmpByDeptId(id);
  }

  /**
   * 添加部门
   * 
   * @param dept
   */
  public void postDept(Dept dept) {
    deptMapper.postDept(dept);
  }

  /**
   * 根据id查找部门
   * 
   * @return dept
   * @param id
   */
  public Dept getDeptById(Integer id) {

    return deptMapper.getDeptById(id);
  }

  /***
   * 修改部门
   * 
   * @param dept
   */
  public void putDept(Dept dept) {
    deptMapper.putDept(dept);
  }
}
