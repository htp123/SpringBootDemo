package com.example.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */
public class SysRole {
    private int id;
    private String role;
    private int available;

    public List<SysPermission> getPermissions(){
        return null;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
