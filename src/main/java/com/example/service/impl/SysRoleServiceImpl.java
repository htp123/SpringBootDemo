package com.example.service.impl;

import com.example.bean.SysPermission;
import com.example.bean.SysRole;
import com.example.mapper.SysRoleMapper;
import com.example.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2018/9/1.
 */
public class SysRoleServiceImpl implements ISysRoleService {
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<SysPermission> getPermissionByRole(SysRole sysRole) {
        List<SysPermission> permissionList = sysRoleMapper.getPermissionByRole(sysRole);
        return permissionList;
    }
}
