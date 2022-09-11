package com.example.userservice.controller;
import com.example.commonservice.model.Result;
import com.example.commonservice.util.ResultUtil;
import com.example.userservice.dao.user.po.UserPO;
import com.example.userservice.model.User;
import com.example.userservigce.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hpl
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    private UserService userService ;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public Result<User> create(@RequestBody User user){
        userService.createUser(user);
        return ResultUtil.buildResult(user);
    }

    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<UserPO>> query(@RequestBody User user){
        List<UserPO> userPOS = userService.queryUser(user);
        return ResultUtil.buildResult(userPOS);
    }

}
