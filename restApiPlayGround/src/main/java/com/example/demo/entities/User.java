package com.example.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

/*Mongo Db Document type*/

@Document
public class User {

    @Id
    private String userId;

    private String userName;
    private String userPwd;
    private HashMap<Integer, String> userTitle;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public HashMap<Integer, String> getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(HashMap<Integer, String> userTitle) {
        this.userTitle = userTitle;
    }
}
