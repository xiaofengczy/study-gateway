package com.study.maven.controller;

import com.study.maven.api.UserApi;
import com.study.maven.entity.Order;
import com.study.maven.entity.User;
import io.swagger.annotations.Api;
import java.util.UUID;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: OrderController Description:
 *
 * @author caozhongyu
 * @create 19-8-2
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单服务")
public class OrderController {

  @Resource
  private UserApi userApi;

  @PostMapping("/add")
  public String addOrder(@RequestBody Order order) {
    return order.toString();
  }

  private Order encapsulateOrderInformation(Integer id) {
    Order order = new Order();
    User user = userApi.findUserById(id);
    order.setUser(user);
    order.setNumber(1);
    order.setOrderNo(UUID.randomUUID().toString());
    order.setPrice(1000);
    return order;
  }

  @GetMapping("/find/{id}")
  public Order addOrder(@PathVariable Integer id) {
    return encapsulateOrderInformation(id);
  }

}