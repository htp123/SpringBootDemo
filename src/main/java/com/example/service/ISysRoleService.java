package com.example.service;

import com.example.bean.SysPermission;
import com.example.bean.SysRole;

import java.util.List;

/**
 * Created by Administrator on 2018/9/1.
 */
public interface ISysRoleService {

    List<SysPermission> getPermissionByRole(SysRole sysRole);
}
