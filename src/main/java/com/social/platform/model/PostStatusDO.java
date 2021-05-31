package com.social.platform.model;

import javax.validation.constraints.NotNull;

public class PostStatusDO {
    @NotNull
    private String emailId;
    @NotNull
    private String status;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
