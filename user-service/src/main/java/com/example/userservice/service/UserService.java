package com.example.userservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.feignapi.pojo.User;
import com.example.userservice.dao.user.dao.UserDao;
import com.example.userservice.dao.user.po.UserPO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hpl
 * @date 2022/9/11 17:25
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User createUser(User user) {
        UserPO userPO = convert2PO(user);
        userDao.save(userPO);
        return user;
    }

    public List<User> queryUser(User user) {
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(user.getId())) {
            queryWrapper.eq("id", user.getId());
        }
        if (!StringUtils.isEmpty(user.getName())) {
            queryWrapper.eq("name", user.getName());
        }

        List<UserPO> userPOS = userDao.list(queryWrapper);
        return convert2List(userPOS);
    }

    List<User> convert2List(List<UserPO> userPOS) {
        if (userPOS == null) {
            return new ArrayList<>();
        }

        return userPOS.stream().map(this::convert).collect(Collectors.toList());
    }

    User convert(UserPO userPO) {
        User user = new User();
        user.setId(userPO.getId());
        user.setName(userPO.getName());
        return user;

    }

    UserPO convert2PO(User user) {
        UserPO userPO = new UserPO();
        userPO.setId(user.getId());
        userPO.setName(user.getName());
        return userPO;

    }

}
