package com.example.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/31.
 */
public class SysRolesPermissions implements Serializable {
    private String roleName;//unique
    private String permission;//unique

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
