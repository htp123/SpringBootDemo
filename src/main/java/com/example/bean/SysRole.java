package com.example.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */
public class SysRole implements Serializable {
    private int id;//unique
    private String role;//unique
    private String description;
    private int available;

/*    public List<SysPermission> getPermissions(){
        return null;
    }*/

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
