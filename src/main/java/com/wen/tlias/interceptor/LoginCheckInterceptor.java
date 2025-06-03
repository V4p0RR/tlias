package com.wen.tlias.interceptor;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson2.JSON;
import org.springframework.util.StringUtils;

import com.wen.tlias.pojo.Result;
import com.wen.tlias.utils.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
// 登录校验拦截器
public class LoginCheckInterceptor implements HandlerInterceptor {

  @SuppressWarnings("null")
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) {

    // 获取req头中的token
    String jwt = req.getHeader("token");
    // 判断jwt是否存在
    if (!StringUtils.hasLength(jwt)) {
      Result error = Result.error("NOT_LOGIN");
      String notLogin = JSON.toJSONString(error);
      log.info("未登录！");
      try {
        resp.getWriter().write(notLogin);
      } catch (IOException e) {
        e.printStackTrace();
      }
      return false;
    }
    // 解析token 如果失败 返回error
    try {
      JwtUtils.parseJWT(jwt);
    } catch (Exception e) {
      e.printStackTrace();
      Result error = Result.error("NOT_LOGIN");
      String notLogin = JSON.toJSONString(error);
      log.info("未登录！");
      try {
        resp.getWriter().write(notLogin);
      } catch (IOException e1) {

        e1.printStackTrace();
      }
      return false;
    }
    log.info("已登录！");
    return true;
  }
}
