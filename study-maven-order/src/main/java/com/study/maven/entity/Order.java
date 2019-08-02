package com.study.maven.entity;

import lombok.Data;

/**
 * FileName: Order Description:
 *
 * @author caozhongyu
 * @create 19-8-2
 */
@Data
public class Order {

  /**订单号*/
  private String orderNo;

  /**用户信息*/
  private User user;

  /**订单数量*/
  private Integer number;

  /**订单总价*/
  private double price;

}