package com.example.userservice.controller;

import com.example.commonservice.model.Result;
import com.example.commonservice.util.ResultUtil;
import com.example.userservice.dao.user.po.UserPO;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hpl
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Result<User> create(@RequestBody User user) {
        userService.createUser(user);
        return ResultUtil.buildResult(user);
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    public Result<List<UserPO>> query(User user) {
        List<UserPO> userPOS = userService.queryUser(user);
        return ResultUtil.buildResult(userPOS);
    }

}
