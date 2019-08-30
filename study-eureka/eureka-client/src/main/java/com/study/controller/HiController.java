package com.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: HiController Description:
 *
 * @author caozhongyu
 * @create 19-8-27
 */
@RestController
public class HiController {

  @Value("${server.port}")
  private String port;

  @GetMapping("/hi")
  public String home(@RequestParam String name){
    return "hi "+name+", i am from port:"+port;
  }
}