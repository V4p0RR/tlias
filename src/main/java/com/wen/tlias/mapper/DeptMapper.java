package com.wen.tlias.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.wen.tlias.pojo.Dept;

@Mapper
public interface DeptMapper {

  /**
   * 查询全部部门
   * 
   * @return
   */ // 由于这个sql语句简单，直接用注解来写sql语句
  @Select("select * from dept") // 自动封装到list集合中
  public List<Dept> list();

  /**
   * 根据id删除部门
   * 
   * @return
   * @param id
   */
  @Delete("delete from dept where id=#{id}")
  public void deleteDeptById(Integer id);

  /**
   * 添加部门
   * 
   * @param dept
   */

  public void postDept(Dept dept);

  /**
   * 根据id查找部门
   * 
   * @param id
   * @return dept对象
   */
  public Dept getDeptById(Integer id);

  /***
   * 修改部门
   * 
   * @param dept
   */
  public void putDept(Dept dept);

}
