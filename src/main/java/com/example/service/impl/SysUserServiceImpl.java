package com.example.service.impl;

import com.example.bean.SysRole;
import com.example.bean.SysUser;
import com.example.mapper.SysUserMapper;
import com.example.service.ISysUserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
        List<SysRole> roleList = sysUserMapper.getRolesByUsername(sysUser.getUserName());
        return roleList;
    }

    @Override
    public List<SysUser> getUserList(Map<String,Object> param) {
        String username = (String)param.get("username");
//        List<SysUser> userList = sysUserMapper.getUserList(username);
        List<SysUser> userList = sysUserMapper.getUserList(param);
        return userList;
    }
}
