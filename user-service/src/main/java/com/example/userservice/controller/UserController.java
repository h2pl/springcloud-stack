package com.example.userservice.controller;

import com.example.commonservice.model.Result;
import com.example.commonservice.util.ResultUtil;
import com.example.feignapi.pojo.User;
import com.example.userservice.config.NacosConfig;
import com.example.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hpl
 */
@RestController
@Slf4j
@RequestMapping("/user/")
@RefreshScope
public class UserController {

    @Resource
    private UserService userService;

    @Value("${pattern.dateformat}")
    private String dateFormat;

    @Value("${name}")
    private String name;

    @Resource
    private NacosConfig nacosConfig;

    @PostMapping("create")
    public Result<User> create(@RequestBody User user) {
        userService.createUser(user);
        return ResultUtil.buildResult(user);
    }

    @GetMapping("query")
    public Result<List<User>> query(User user) {
        List<User> userPOS = userService.queryUser(user);
        return ResultUtil.buildResult(userPOS);
    }

    @GetMapping("test")
    public String test() {
        log.debug(dateFormat);
        log.debug(nacosConfig.getDateformat());
        log.debug(nacosConfig.getShareEnv());
//        return nacosConfig.getDateformat();
        return name;
    }

}
