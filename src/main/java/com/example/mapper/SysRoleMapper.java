package com.example.mapper;

import com.example.bean.SysPermission;
import com.example.bean.SysRole;
import org.apache.ibatis.annotations.Select;

import java.security.Permission;
import java.util.List;

/**
 * Created by Administrator on 2018/9/1.
 */
public interface SysRoleMapper {

    @Select("select * from sys_permissions t1,roles_permissions t2,sys_roles t3 where t1.permission = t2.permission and t2.role_name = t3.role and t3.role = #{role.role}")
    List<SysPermission> getPermissionByRole(SysRole sysRole);

}
