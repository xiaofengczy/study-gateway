package com.study.feign.controller;

import com.study.feign.entity.User;
import com.study.feign.api.UserFeignApi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: UserController Description:
 *
 * @author caozhongyu
 * @create 19-7-31
 */
@RestController
public class UserController implements UserFeignApi {

  public String addUser(User user){
    return "hello, "+user.getName();
  }

  public String updateUser(@RequestBody User user){
    return "hello, "+user.getName();
  }
}