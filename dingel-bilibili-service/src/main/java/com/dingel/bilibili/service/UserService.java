package com.dingel.bilibili.service;


import com.dingel.bilibili.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.dc.pr.PRError;

@Service
public class UserService {


    @Autowired
    private UserDao userDao;



}
