package com.example.service.impl;

import com.example.bean.SysPermission;
import com.example.bean.SysRole;
import com.example.mapper.SysRoleMapper;
import com.example.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/9/1.
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {
//    @Autowired
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysPermission> getPermissionByRole(SysRole sysRole) {
        List<SysPermission> permissionList = sysRoleMapper.getPermissionByRoleId(sysRole.getRole());
        return permissionList;
    }
}
