package com.wen.tlias.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean { // 用于封装total和emps列表
  private int total;
  private List<Emp> rows;

}
