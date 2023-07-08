package com.iweb.mapper;

import com.iweb.entity.User;

import java.util.Map;

/**
 * untitled1_0704   IntelliJ IDEA
 * UserMapper
 *
 * @param
 * @author minghuachen
 * @date 2023/7/4 15:38
 */
public interface UserMapper {
    public int login(Map map);
    public Map updateWhenFail(Map map);
}
