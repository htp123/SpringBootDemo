package com.example.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */
public class SysUser implements Serializable {
    private int id;//unique
    private String userName;//unique
    private String password;
    private String salt;
    private String locked;

  /*  public List<SysRole> getRoleList(){

        return null;
    }*/

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

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }
}
