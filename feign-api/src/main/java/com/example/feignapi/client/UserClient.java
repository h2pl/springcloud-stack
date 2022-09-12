package com.example.feignapi.client;

import com.example.commonservice.model.Result;
import com.example.feignapi.config.DefaultFeignConfiguration;
import com.example.feignapi.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hpl
 * @date 2022/9/11 23:43
 */

@FeignClient(value = "user-service", configuration = DefaultFeignConfiguration.class)
public interface UserClient {

    @GetMapping("/user/query")
    Result<List<User>> query(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name);
}
