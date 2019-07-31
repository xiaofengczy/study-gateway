package com.study.feign.entity;

import lombok.Data;

/**
 * FileName: User Description:
 *
 * @author caozhongyu
 * @create 19-7-31
 */
@Data
public class User {

  /**
   * 姓名
   */
  private String name;

  /**
   * 年龄
   */
  private Integer age;

  /**
   * id
   */
  private Integer id;
}