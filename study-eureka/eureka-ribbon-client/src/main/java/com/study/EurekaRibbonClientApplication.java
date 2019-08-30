package com.study;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * FileName: EurekaRibbonClientApplication Description:
 *
 * @author caozhongyu
 * @create 19-8-28
 */
@SpringBootApplication
@EnableHystrix
@EnableDiscoveryClient
@EnableHystrixDashboard
public class EurekaRibbonClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaRibbonClientApplication.class, args);
  }

  @LoadBalanced
  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean
  public ServletRegistrationBean getServlet(){

    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
    registrationBean.setLoadOnStartup(1);  //系统启动时加载顺序
    registrationBean.addUrlMappings("/hystrix.stream");//路径
    registrationBean.setName("HystrixMetricsStreamServlet");
    return registrationBean;
  }
}