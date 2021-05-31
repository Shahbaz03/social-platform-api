package com.social.platform.data;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Object for User
 * @author Shahbaz.Alam
 */
public class User {
    @Id
    private String _id;
    @NotNull
    private String emailId;
    @NotNull
    private String name;
    private List<Post> posts;
    private List<String> usersFollowed;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<Post> getPosts() {
        if (this.posts == null) {
            this.posts = new ArrayList<>();
        }
        return this.posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<String> getUsersFollowed() {
        if (this.usersFollowed == null) {
            this.usersFollowed = new ArrayList<>();
        }
        return this.usersFollowed;
    }

    public void setUsersFollowed(List<String> usersFollowed) {
        this.usersFollowed = usersFollowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public User() {

    }

    public User(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }
}
