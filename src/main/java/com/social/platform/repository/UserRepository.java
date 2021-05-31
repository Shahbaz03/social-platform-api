package com.social.platform.repository;

import com.social.platform.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmailId(String emailId);

    List<User> findByName(String name);
}
