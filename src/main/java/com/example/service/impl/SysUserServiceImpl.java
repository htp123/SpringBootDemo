package com.example.service.impl;

import com.example.bean.SysRole;
import com.example.bean.SysUser;
import com.example.mapper.SysUserMapper;
import com.example.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUsername(String userName) {

        SysUser user = sysUserMapper.findByUsername(userName);
        return user;
    }

   /* @Override
    public List<SysRole> getRoleList(SysUser sysUser) {
        return null;
    }*/
}
