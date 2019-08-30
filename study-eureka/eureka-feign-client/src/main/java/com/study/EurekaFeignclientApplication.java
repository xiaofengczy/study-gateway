package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * FileName: FeignclientApplication Description:
 *
 * @author caozhongyu
 * @create 19-8-28
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class EurekaFeignclientApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaFeignclientApplication.class, args);
  }
}