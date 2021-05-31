package com.social.platform.service;

import com.social.platform.data.Post;
import com.social.platform.data.User;
import com.social.platform.exception.InvalidPostException;
import com.social.platform.exception.UserAlreadyExistsException;
import com.social.platform.exception.UserNotFoundException;
import com.social.platform.model.FollowUserDO;
import com.social.platform.model.PostStatusDO;
import com.social.platform.model.TimelineDO;
import com.social.platform.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final int Max_Limit = 140;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void postStatus(PostStatusDO postStatusDO) {
        if (postStatusDO.getStatus().length() > Max_Limit) {
            logger.error("invalid post. post status is greater than 140 char");
            throw new InvalidPostException("status post should be within 140 characters");
        }
        User user = getUser(postStatusDO.getEmailId());
        if (user == null) {
            logger.error("failed to post status, user not found with emailId: " + postStatusDO.getEmailId());
            throw new UserNotFoundException("user not found, emailId: " + postStatusDO.getEmailId());
        }
        user.getPosts().add(0, new Post(postStatusDO.getStatus()));
        userRepository.save(user);
        logger.info("status posted successfully");
    }

    @Override
    public User followUser(FollowUserDO followUserDO) {
       User user = getUser(followUserDO.getEmailId());
       if (user == null) {
           logger.error("failed to follow user, user not found with emailId: " + followUserDO.getEmailId());
           throw new UserNotFoundException("user not found, emailId: " + followUserDO.getEmailId());
       }
       User followUser = getUser(followUserDO.getFollowUser());
       if (followUser == null) {
           logger.error("failed to follow user, user not found with emailId: " + followUserDO.getFollowUser());
           throw new UserNotFoundException("user not found, emailId: " + followUserDO.getFollowUser());
       }

       user.getUsersFollowed().add(followUserDO.getFollowUser());

       logger.info("user follow successful");
       return userRepository.save(user);
    }

    @Override
    public User createUser(User user) {
        if (getUser(user.getEmailId()) != null) {
            logger.error("failed to create user, user already exists with emailId: " + user.getEmailId());
            throw new UserAlreadyExistsException("user already exists with emailId: " + user.getEmailId());
        }

        logger.info("user created successfully");
        return userRepository.insert(new User(user.getName(), user.getEmailId()));
    }

    @Override
    public List<User> getUsers() {
        logger.info("retrieving all users");
        return userRepository.findAll();
    }

    @Override
    public List<TimelineDO> getTimeline(String emailId) {
        User user = getUser(emailId);
        if (user == null) {
            logger.error("failed to get timeline response, user not found with emailId: " + emailId);
            throw new UserNotFoundException("user not found, emailId: " + emailId);
        }
        logger.info("fetching timeline response for user: " + emailId);
        List<TimelineDO> timelineList = user.getUsersFollowed()
                .stream()
                .flatMap(e -> populateTimelineDO(getUser(e)).stream())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        return timelineList;
    }

    @Override
    public User getUser(String emailId) {
        logger.info("fetching user: " + emailId);
        return userRepository.findByEmailId(emailId);
    }

    private List<TimelineDO> populateTimelineDO(User user) {
        List<TimelineDO> timelineDOList = new ArrayList<>();
        TimelineDO timelineDO = null;
        for (Post post : user.getPosts()) {
            timelineDO = new TimelineDO();
            timelineDO.setStatus(post.getStatus());
            timelineDO.setStatusTime(post.getTime());
            timelineDO.setName(user.getName());
            timelineDO.setEmailId(user.getEmailId());
            timelineDOList.add(timelineDO);
        }
        return timelineDOList;
    }
}
