package com.example.service;

import com.example.bean.SysRole;
import com.example.bean.SysUser;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/31.
 */
//@Repository
public interface  ISysUserService {
    SysUser findByUsername(String userName);

    List<SysRole> getRoleListByUser(SysUser sysUser);

    public List<SysUser> getUserList(Map<String,Object> param);
}
