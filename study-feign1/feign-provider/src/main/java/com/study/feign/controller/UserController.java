package com.study.feign.controller;

import com.study.feign.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: UserController Description:
 *
 * @author caozhongyu
 * @create 19-7-31
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping("/add")
  public String addUser(User user){
    return "hello, "+user.getName();
  }

  @PostMapping("/update")
  public String updateUser(@RequestBody User user){
    return "hello, "+user.getName();
  }
}