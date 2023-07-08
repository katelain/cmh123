package com.iweb.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * untitled1_0704   IntelliJ IDEA
 * UserInfoMapper
 *
 * @param
 * @author minghuachen
 * @date 2023/7/4 16:19
 */
public interface UserInfoMapper {
    public List<Map> showAll();

    public boolean addUserInfo(Map map);

    public boolean delUserInfoMany(String[] ids);


    public boolean updateUserInfo(Map map);



}
