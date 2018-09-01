package com.example.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/31.
 */
public class SysUsersRoles implements Serializable {
    private int userId;
    private int roleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
