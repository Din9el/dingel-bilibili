package com.dingel.bilibili.dao;


import com.dingel.bilibili.domain.User;
import com.dingel.bilibili.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User getUserByPhone(String phone);

    Integer addUser(User user);

    Integer addUserInfo(UserInfo userInfo);
}
