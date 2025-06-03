package com.wen.tlias.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

//属性注入pojo
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
  private String endpoint;

  private String accessKeyId;

  private String accessKeySecret;

  private String bucketName;

}
