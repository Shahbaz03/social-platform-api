package com.social.platform.controller;

import com.social.platform.data.User;
import com.social.platform.exception.UserNotFoundException;
import com.social.platform.model.FollowUserDO;
import com.social.platform.model.PostStatusDO;
import com.social.platform.model.TimelineDO;
import com.social.platform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Rest Layer for API Interaction
 * @author shahbaz.alam
 */
@RestController
@RequestMapping("/api")
public class SocialApiController {
    private static final Logger logger = LoggerFactory.getLogger(SocialApiController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/users/{emailId:.+}")
    public User getUser(@PathVariable("emailId") String emailId) {
        User user = userService.getUser(emailId);
        if (user == null) {
            throw new UserNotFoundException("user not found, emailId: " + emailId);
        }
        return user;
    }

    @PostMapping("/status")
    public void updateStatus(@Valid @RequestBody PostStatusDO postStatusDO) {
        userService.postStatus(postStatusDO);
    }

    @PostMapping("/follow")
    public User followUser(@Valid @RequestBody FollowUserDO followUserDO) {
        return userService.followUser(followUserDO);
    }

    @GetMapping("/users/{emailId:.+}/timeline")
    public List<TimelineDO> getTimeline(@PathVariable("emailId") String emailId) {
        return userService.getTimeline(emailId);
    }
}
