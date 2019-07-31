package com.study.feign.controller;

import com.study.feign.api.UserFeignApi;
import com.study.feign.entity.User;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
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

  @Resource
  private UserFeignApi userFeignApi;

  @PostMapping(value = "/add")
  public String addUser(@RequestBody
  @ApiParam(name = "用户", value = "传入json格式", required = true)
      User user) {
    return userFeignApi.addUser(user);
  }

  @PostMapping(value = "/update")
  public String updateUser(@RequestBody
  @ApiParam(name = "用户", value = "传入json格式", required = true)
      User user) {
    return userFeignApi.updateUser(user);
  }
}