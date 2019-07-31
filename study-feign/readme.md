### 【Spring Cloud】学习笔记之feign

一、简介

​	Feign是一种声明式的Web Service客户端，Spring Cloud中使用Feign，可以使开发者无感知调用远程服务,像调用本地方法一样

二、环境准备 

​	本次案例需要准备如下三个工程，注册中心、服务提供者、服务消费者

| 工程名            | 端口 | 作用                 |
| ----------------- | ---- | -------------------- |
| eureka-service    | 8067 | 注册中心             |
| feign-service     | 8011 | 服务提供者           |
| feign-client      | 8012 | 服务消费者           |
| feign-service-api | 8013 | 提供Feign调用api接口 |

三、涉及知识点

​	1.Srpingcloud项目搭建

​	2.Feign调用实现

​	3.项目集成Swagger

​	4.GET请求在Feign调用处理

#### 1.入门案例

​	入门案例包括以下几个方面知识点

​	1.SpringCloud项目搭建

​	2.Feign调用简单实现

​	3.项目集成Swagger

​	4.Feign调用时GET请求处理

**（1）SpringCloud项目搭建**

- 引进依赖

  ```xml
  <!--引入springboot-parent依赖,决定springboot版本-->
  <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>2.1.4.RELEASE</version>
    </parent>
  <!--配置jdk版本和springcloud版本-->
    <properties>
      <java.version>1.8</java.version>
      <spring.cloud.version>Finchley.SR2</spring.cloud.version>
    </properties>
    <dependencies>
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
    </dependencies>
  <!--统一管理springcloud版本 -->
    <dependencyManagement>
      <dependencies>
        <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-dependencies</artifactId>
          <version>${spring.cloud.version}</version>
          <type>pom</type>
          <scope>import</scope>
        </dependency>
      </dependencies>
    </dependencyManagement>
  ```

  

- 创建注册中心服务

  - 引入依赖(只需引入eureka-server依赖即可)

    ```xml
      <dependencies>
        <dependency>
          <groupId>org.springframework.cloud</gr（1）SpringCloud项目搭建oupId>
          <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
      </dependencies>
    ```

    

  - 启动类

    ```java
    @SpringBootApplication
    @EnableEurekaServer //表明为Eureka服务端
    public class EurekaServerApplication {
    
      public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
      }
    }
    ```

    

  - 配置文件

    ```yml
    server:
      port: 8761
    
    eureka:
      instance:
        hostname: localhost
      client:
        fetch-registry: false # 
        register-with-eureka: false # 是否将该服务注册至Eureka，由于是服务端，故不注册
        service-url:
          defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
    ```

    

- 创建服务提供者

  > 服务提供者必较简单，其实就是单纯提供处理请求即可

  - 引入依赖

    ```xml
     <dependencies>
        <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
          <groupId>org.projectlombok</groupId>
          <artifactId>lombok</artifactId>
        </dependency>
      </dependencies>
    ```

  - 启动类

    ```java
    @EnableEurekaClient
    @SpringBootApplication
    public class FeignProviderApplication {
    
      public static void main(String[] args) {
        SpringApplication.run(FeignProviderApplication.class, args);
      }
    }
    ```

  - 配置文件 

    ```yml
    server:
      port: 8012
    eureka:
      instance:
        hostname: localhost
      client:
        service-url:
          defaultZone: http://localhost:8761/eureka/
    spring:
      application:
        name: feign-provider
    ```

    

- 创建服务消费者

  消费者服务主要有如下几个知识点

  

#### 2.Swagger集成

