package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * FileName: EurekaClientApplication Description:
 *
 * @author caozhongyu
 * @create 19-8-27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaClientApplication.class, args);
  }
}