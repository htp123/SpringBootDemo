package com.example.service;

import com.example.bean.SysRole;
import com.example.bean.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/31.
 */
//@Repository
public interface  ISysUserService {
    SysUser findByUsername(String userName);

    List<SysRole> getRoleListByUser(SysUser sysUser);
}
