package com.social.platform.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String status;
    private String time;

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public Post(String status) {
        this.status = status;
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        this.time = currentDateTime.format(formatter);
    }
}
