package com.example.service;

import com.example.bean.SysRole;
import com.example.bean.SysUser;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */
public interface  ISysUserService {
    SysUser findByUsername(String userName);

//    List<SysRole> getRoleList(SysUser sysUser);
}
