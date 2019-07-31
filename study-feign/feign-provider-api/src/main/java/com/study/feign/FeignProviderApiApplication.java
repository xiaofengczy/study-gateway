package com.study.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * FileName: FeignProviderApiApplication Description:
 *
 * @author caozhongyu
 * @create 19-7-31
 */
@SpringBootApplication
@EnableEurekaClient
public class FeignProviderApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeignProviderApiApplication.class);
  }

}