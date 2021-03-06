package com.example.mapper;

import com.example.bean.SysPermission;
import com.example.bean.SysRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.List;

/**
 * Created by Administrator on 2018/9/1.
 */
@Component
public interface SysRoleMapper {

//    @Select("select * from sys_permissions t1,roles_permissions t2,sys_roles t3 where t1.permission = t2.permission and t2.role_name = t3.role and t3.id = #{roleId}")
    @Select("select t1.* from sys_permissions t1,sys_roles_permissions t2,sys_roles t3  where t1.id=t2.permission_id and t2.role_id=t3.id and t3.id='37';")
    List<SysPermission> getPermissionByRoleId(String roleId);

}
