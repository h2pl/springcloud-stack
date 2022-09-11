package com.example.orderservice.feign;

import com.example.commonservice.model.Result;
import com.example.userservice.dao.user.po.UserPO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hpl
 * @date 2022/9/11 23:43
 */

@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/user/query")
    Result<List<UserPO>> query(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name);
}
