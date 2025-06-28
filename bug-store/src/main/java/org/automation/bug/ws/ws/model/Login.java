package org.automation.bug.ws.ws.model;

import jakarta.persistence.Entity;

import java.sql.Date;

@Entity
public class Login {
    private String userName;
    private String password;
    private String dateTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public Date getDate() {
        return Date.valueOf(dateTime);
    }
}
