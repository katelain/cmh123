package com.iweb.service;

import java.util.Map;

/**
 * untitled1_0704   IntelliJ IDEA
 * UserSrevice
 *
 * @param
 * @author minghuachen
 * @date 2023/7/4 15:43
 */
public interface UserService {
    public int login(Map map);

    public Map updateWhenFail(Map map);
}
