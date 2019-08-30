package com.study.controller;

import com.study.service.RibbonService;
import javax.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: EurekaRibbonClient Description:
 *
 * @author caozhongyu
 * @create 19-8-28
 */
@RestController
public class EurekaRibbonClient {

  @Resource
  private RibbonService ribbonService;

  @Resource
  private LoadBalancerClient loadBalancerClient;

  @GetMapping("/hi")
  public String hi(@RequestParam("name") String name) {
    return ribbonService.hi(name);
  }

  @GetMapping("/testRibbon")
  public String testRibbon() {

    ServiceInstance instance = loadBalancerClient.choose("stores");
    return instance.getHost() + ":" + instance.getPort();
  }
}