package com.iweb.entity;

import java.util.Date;

public class User {
    private String uid;
    private String username;
    private String password;
    private Integer failcount;
    private Date logintime;


    public User() {
    }

    public User(String uid, String username, String password, Integer failcount, Date logintime) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.failcount = failcount;
        this.logintime = logintime;
    }

    /**
     * 获取
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return failcount
     */
    public Integer getFailcount() {
        return failcount;
    }

    /**
     * 设置
     * @param failcount
     */
    public void setFailcount(Integer failcount) {
        this.failcount = failcount;
    }

    /**
     * 获取
     * @return logintime
     */
    public Date getLogintime() {
        return logintime;
    }

    /**
     * 设置
     * @param logintime
     */
    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String toString() {
        return "User{uid = " + uid + ", username = " + username + ", password = " + password + ", failcount = " + failcount + ", logintime = " + logintime + "}";
    }
}
