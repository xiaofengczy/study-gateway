package com.study.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * FileName: FeignProviderApplication Description:
 *
 * @author caozhongyu
 * @create 19-7-31
 */
@EnableEurekaClient
@SpringBootApplication
public class FeignProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeignProviderApplication.class, args);
  }
}