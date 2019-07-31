package com.study.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * FileName: FeignConsumerApplication Description:
 *
 * @author caozhongyu
 * @create 19-7-31
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
public class FeignConsumerApplication {

  public static void main(String[] args){
    SpringApplication.run(FeignConsumerApplication.class);
  }

}