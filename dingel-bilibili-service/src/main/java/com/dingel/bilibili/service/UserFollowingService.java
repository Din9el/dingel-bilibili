package com.dingel.bilibili.service;

import com.dingel.bilibili.dao.FollowingGroupDao;
import com.dingel.bilibili.dao.UserFollowingDao;
import com.dingel.bilibili.domain.FollowingGroup;
import com.dingel.bilibili.domain.UserFollowing;
import com.dingel.bilibili.domain.constant.UserConstant;
import com.dingel.bilibili.domain.exception.ConditionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFollowingService {

    @Autowired
    private UserFollowingDao userFollowingDao;

    @Autowired
    private FollowingGroupService followingGroupService;


    private void addUserFollowings(UserFollowing userFollowing){
        Long groupId = userFollowing.getGroupId();
        if(groupId == null){
            FollowingGroup followingGroup = followingGroupService.getByType(UserConstant.USER_FOLLOWING_GROUP_TYPE_DEFAULT);
            userFollowing.setGroupId(followingGroup.getId());
        } else{
            FollowingGroup  followingGroup = followingGroupService.getById(groupId);
            if (followingGroup == null){
                throw new ConditionException("关注分组不存在");
            }
        }

    }

}
