package com.study.feign.api;

import com.study.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * FileName: UserFeignService Description:
 *
 * @author caozhongyu
 * @create 19-7-31
 */
@FeignClient(name = "feign-provider")
public interface UserFeignApi {

  @GetMapping(value = "/user/add")
  String addUser(User user);

  @PostMapping(value = "/user/update")
  String updateUser(@RequestBody User user);

}