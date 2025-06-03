package com.wen.tlias.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.wen.tlias.pojo.Emp;
import com.wen.tlias.pojo.Result;
import com.wen.tlias.service.EmpService;
import com.wen.tlias.utils.JwtUtils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
public class LoginController {
  @Autowired
  private EmpService empService;

  // TODO 登录功能
  @PostMapping("/login")
  public Result postMethodName(@RequestBody Emp emp) {

    Emp e = empService.login(emp);
    log.info("登录操作 用户：{}", e);
    // 如果e不为空 登录成功 返回token
    if (e != null) {
      Map<String, Object> claims = new HashMap<>();
      claims.put("id", e.getId());
      claims.put("name", e.getName());
      claims.put("username", e.getUsername());
      claims.put("password", e.getPassword());
      String token = JwtUtils.generateJwt(claims);
      log.info("登录成功,token{}", token);
      return Result.success(token);
    }
    ;
    // 如果为空，返回错误信息
    return Result.error("用户名或密码错误！");

  }

}
