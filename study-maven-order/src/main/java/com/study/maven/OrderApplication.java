package com.study.maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * FileName: OrderApplication Description:
 *
 * @author caozhongyu
 * @create 19-8-2
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class OrderApplication {
  public static void main(String[] args){
    SpringApplication.run(OrderApplication.class);
  }

}