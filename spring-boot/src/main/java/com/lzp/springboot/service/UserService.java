package com.lzp.springboot.service;

import com.lzp.springboot.mapper.UserMapper;
import com.lzp.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 *
 * @authorHmLzp
 * @create 2019 - 01 - 30 10:08
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserById(Integer id){
        return userMapper.getUserById(id);
    }

    public List<User> getUsers(){
        return userMapper.getUsers();
    }
}
