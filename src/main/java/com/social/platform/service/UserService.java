package com.social.platform.service;

import com.social.platform.data.User;
import com.social.platform.model.FollowUserDO;
import com.social.platform.model.PostStatusDO;
import com.social.platform.model.TimelineDO;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getUsers();

    User getUser(String emailId);

    void postStatus(PostStatusDO postStatusDO);

    User followUser(FollowUserDO followUserDO);

    List<TimelineDO> getTimeline(String emailId);
}
