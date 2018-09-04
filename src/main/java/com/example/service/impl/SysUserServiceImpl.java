package com.example.service.impl;

import com.example.bean.SysRole;
import com.example.bean.SysUser;
import com.example.mapper.SysUserMapper;
import com.example.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
//    @Autowired
    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public SysUser findByUsername(String userName) {

        SysUser user = sysUserMapper.findByUsername(userName);
        return user;
    }

    @Override
    public List<SysRole> getRoleListByUser(SysUser sysUser) {
        List<SysRole> roleList = sysUserMapper.getRolesByUser(sysUser);
        return roleList;
    }

   /* @Override
    public List<SysRole> getRoleList(SysUser sysUser) {
        return null;
    }*/
}
