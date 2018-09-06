package com.example.service;

import com.example.bean.SysPermission;
import com.example.bean.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/9/1.
 */
//@Repository
public interface ISysRoleService {

    List<SysPermission> getPermissionByRole(SysRole sysRole);
}
