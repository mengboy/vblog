package com.vector.blog.service.impl;

import com.vector.blog.mapper.UserMapper;
import com.vector.blog.model.User;
import com.vector.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by vector on 2017/5/12.
 */
@Service("UserService")
public class IUserService implements UserService{
    @Resource
    UserMapper userMapper;

    public User getUserByName(String userName) {
        try {
            return userMapper.selectByUserName(userName);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
