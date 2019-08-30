package com.study.exception;

import com.study.service.EurekaFeignclientService;
import org.springframework.stereotype.Component;

/**
 * FileName: HiError Description:
 *
 * @author caozhongyu
 * @create 19-8-30
 */
@Component
public class HiError implements EurekaFeignclientService {

  @Override
  public String sayHello(String name) {
    return "sorry,your name:"+name+"has error";
  }
}