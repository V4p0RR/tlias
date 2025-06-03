package com.wen.tlias.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wen.tlias.interceptor.LoginCheckInterceptor;

//拦截器配置文件
@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Autowired
  private LoginCheckInterceptor loginCheckInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
  }
}
