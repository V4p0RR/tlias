package com.wen.tlias.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wen.tlias.pojo.Result;

import lombok.extern.slf4j.Slf4j;
import com.wen.tlias.utils.*;;

@Slf4j
@RestController
public class UploadController {
  @Autowired
  private AliOSSUtils aliOSSUtils;

  @PostMapping("/upload")
  // TODO 文件上传
  public Result uploadFile(MultipartFile image) throws IOException {

    log.info("文件上传 文件名：{}", image.getOriginalFilename());
    String url = aliOSSUtils.upload(image);
    log.info("上传完成,url为{}", url);
    return Result.success(url);
  }
}
