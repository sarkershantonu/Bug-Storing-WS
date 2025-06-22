package org.automation.bug.ws.ws.model;

import jakarta.persistence.Entity;

@Entity
public class Login {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public Login() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
