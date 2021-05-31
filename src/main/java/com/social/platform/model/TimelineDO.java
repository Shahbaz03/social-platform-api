package com.social.platform.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimelineDO implements Comparable<TimelineDO> {
    private String name;
    private String emailId;
    private String status;
    private String statusTime;

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(TimelineDO o) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        return LocalDateTime.parse(this.statusTime, formatter)
                .compareTo(LocalDateTime.parse(o.statusTime, formatter));
    }
}
