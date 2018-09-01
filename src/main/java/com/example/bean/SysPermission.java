package com.example.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/31.
 */
public class SysPermission implements Serializable
{
    private int id;//unique
    private String permission;//unique
    private int available;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
