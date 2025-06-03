package com.wen.tlias.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wen.tlias.pojo.Result;

//TODO 全局异常处理类
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(Exception.class) // 捕获所有异常
  public Result ex(Exception e) {
    e.printStackTrace();
    return Result.error("发生异常,请联系无上至尊专属部门的V1rtual");
  }
}
