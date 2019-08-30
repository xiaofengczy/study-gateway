package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * FileName: EurekaZuulClientApplication Description:
 *
 * @author caozhongyu
 * @create 19-8-30
 */
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaZuulClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaZuulClientApplication.class, args);
  }
}