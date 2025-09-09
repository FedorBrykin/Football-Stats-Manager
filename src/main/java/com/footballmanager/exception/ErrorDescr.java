package com.footballmanager.exception;

import java.util.Date;

public class ErrorDescr {
    private Date time;
    private String message;
    private String details;

    public ErrorDescr(Date time, String message, String details) {
        this.time = time;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() { return time; }
    public String getMessage() { return message; }
    public String getDetails() { return details; }
}
