package com.iweb.service.impl;

import com.iweb.mapper.UserMapper;
import com.iweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * untitled1_0704   IntelliJ IDEA
 * UserServiceImpl
 *
 * @param
 * @author minghuachen
 * @date 2023/7/4 15:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int login(Map map) {
        return userMapper.login(map);
    }

    @Override
    public Map updateWhenFail(Map map) {
        return userMapper.updateWhenFail(map);
    }
}
