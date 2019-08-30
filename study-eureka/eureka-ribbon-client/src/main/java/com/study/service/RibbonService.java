package com.study.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * FileName: RibbonService Description:
 *
 * @author caozhongyu
 * @create 19-8-28
 */
@Service
public class RibbonService {

  @Resource
  private RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "hiError")
  public String hi(String name){
    return restTemplate.getForObject("http://eureka-client/hi?name={1}", String.class, name);
  }

  public String hiError(String name){
    return "sorror,request user name:"+name +",has error";
  }
}