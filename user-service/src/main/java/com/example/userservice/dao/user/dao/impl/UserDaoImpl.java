package com.example.userservice.dao.user.dao.impl;

import com.example.userservice.dao.user.po.UserPO;
import com.example.userservice.dao.user.mapper.UserMapper;
import com.example.userservice.dao.user.dao.UserDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hpl
 * @since 2022-09-11
 */
@Service
public class UserDaoImpl extends ServiceImpl<UserMapper, UserPO> implements UserDao {

}
