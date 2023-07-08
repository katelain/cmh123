package com.iweb.service.impl;

import com.iweb.mapper.UserInfoMapper;
import com.iweb.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * untitled1_0704   IntelliJ IDEA
 * UserInfoServiceImpl
 *
 * @param
 * @author minghuachen
 * @date 2023/7/4 16:13
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<Map> showAll() {
        return userInfoMapper.showAll();
    }

    @Override
    public boolean addUserInfo(Map map) {
        return userInfoMapper.addUserInfo(map);
    }

    @Override
    public boolean delUserInfoMany(String[] ids) {
        return userInfoMapper.delUserInfoMany(ids);
    }


    @Override
    public boolean updateUserInfo(Map map) {
        return userInfoMapper.updateUserInfo(map);
    }




}
