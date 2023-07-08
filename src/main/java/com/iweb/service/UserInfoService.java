package com.iweb.service;

import com.iweb.entity.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * untitled1_0704   IntelliJ IDEA
 * UserInfoService
 *
 * @param
 * @author minghuachen
 * @date 2023/7/4 16:13
 */
public interface UserInfoService {
    public List<Map> showAll();

    public boolean addUserInfo(Map map);

    public boolean delUserInfoMany(String[] ids);



    public boolean updateUserInfo(Map map);


}
