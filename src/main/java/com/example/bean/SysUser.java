package com.example.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */
public class SysUser {
    private int id;
    private String userName;
    private String password;
    private String salt;
    private int locked;

    public List<SysRole> getRoleList(){

        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}