package com.study.controller;

import com.study.service.EurekaFeignclientService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: FeignclientController Description:
 *
 * @author caozhongyu
 * @create 19-8-28
 */
@RestController
public class FeignclientController {

  @Resource
  private EurekaFeignclientService feignclientService;

  @GetMapping("/feign/hi")
  public String hi(@RequestParam("name") String name) {
    return feignclientService.sayHello(name);
  }

}