package com.social.platform;

import com.social.platform.data.User;
import com.social.platform.model.PostStatusDO;
import com.social.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Starter APP
 * @author Shahbaz.Alam
 */
@SpringBootApplication
public class SocialPlatformServiceStarter {
    public static void main(String[] args) {
        SpringApplication.run(SocialPlatformServiceStarter.class, args);
    }
}

/**
 * DataBuilder to create dummy data for the APIs
 */
@Component
class DataBuilder implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("Shahbaz Alam", "shahbaz@abc.com");
        User user2 = new User("Deepak Ahuja", "deepak@abc.com");
        User user3 = new User("Deepesh Sharma", "deepesh@abc.com");

        userService.createUser(user1);
        userService.createUser(user2);
        userService.createUser(user3);

        PostStatusDO post1 = new PostStatusDO();
        post1.setEmailId("shahbaz@abc.com");
        post1.setStatus("Hello...This is my first post");

        PostStatusDO post2 = new PostStatusDO();
        post2.setEmailId("deepak@abc.com");
        post2.setStatus("Hello...This is my first post");

        PostStatusDO post3 = new PostStatusDO();
        post3.setEmailId("shahbaz@abc.com");
        post3.setStatus("Hello...This is my second post");

        PostStatusDO post4 = new PostStatusDO();
        post4.setEmailId("shahbaz@abc.com");
        post4.setStatus("Hello...This is my third post");

        PostStatusDO post5 = new PostStatusDO();
        post5.setEmailId("deepesh@abc.com");
        post5.setStatus("Hello...This is my first post");

        userService.postStatus(post1);
        userService.postStatus(post2);
        userService.postStatus(post3);
        userService.postStatus(post4);
        userService.postStatus(post5);
    }
}
