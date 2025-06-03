package com.wen.tlias.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.wen.tlias.pojo.Emp;

@Mapper
public interface EmpMapper {
  /**
   * 根据条件分页查找员工
   * 
   * @param emp
   * @param begin
   * @param end
   * @param pageStart
   * @param pageSize
   * @return
   */

  List<Emp> getEmpsByMany(Emp emp, LocalDate begin, LocalDate end, Integer pageStart, Integer pageSize);

  int getTotal(Emp emp, LocalDate begin, LocalDate end);

  /**
   * 根据ids批量删除员工
   * 
   * @param ids
   */
  void deleteByIds(Integer[] ids);

  /**
   * 添加员工
   * 
   * @param emp
   */
  void postEmp(Emp emp);

  // 根据id查找员工
  Emp getEmpById(Integer id);

  /**
   * 修改员工
   * 
   * @param emp
   */
  void putEmp(Emp emp);

  /**
   * 登录功能 根据用户名和密码查询emp
   * 
   * @param emp
   * @return
   */
  Emp getEmpByUsernameAndPassword(Emp emp);

  @Delete("delete from emp where dept_id=#{id}")
  void deleteEmpByDeptId(Integer id);
}
