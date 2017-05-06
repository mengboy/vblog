package com.vector.blog.model.admin;

/**
 * Created by vector on 2017/4/16.
 */
public class Admin {
    //imageUrl
    private String userAvatar;

    private String nickName;
    private String userName;

    public String getUserAvatar() {
        return userAvatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Admin(String nickName, String userName) {
        this.nickName = nickName;
        this.userName = userName;
    }

    public Admin() {
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
}
