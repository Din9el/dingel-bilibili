package com.dingel.bilibili.service;


import com.dingel.bilibili.dao.FollowingGroupDao;
import com.dingel.bilibili.domain.FollowingGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingGroupService {

    @Autowired
    private FollowingGroupDao followingGroupDao;


    public FollowingGroup getByType(String type){
        return followingGroupDao.getByType(type);
    }


    public FollowingGroup getById(Long id){
        return followingGroupDao.getById(id);
    }


    public List<FollowingGroup> getUserById(Long userId) {
        return followingGroupDao.getUserById(userId);
    }
}
