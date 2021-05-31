package com.social.platform.model;

import javax.validation.constraints.NotNull;

public class FollowUserDO {
    @NotNull
    private String emailId;
    @NotNull
    private String followUser;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFollowUser() {
        return followUser;
    }

    public void setFollowUser(String followUser) {
        this.followUser = followUser;
    }
}
