package com.example.mapper;

/**
 * Created by Administrator on 2018/8/27.
 */

import com.example.bean.SysRole;
import com.example.bean.SysUser;
import com.example.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

// @Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，所以统一配置@MapperScan在扫描路径在application类中
/*@Mapper*/

public interface SysUserMapper {

    @Select("select * from sys_users where username = #{userName}")
    SysUser findByUsername(String userName);

    @Select("select t1.* from sys_roles t1,sys_users_roles t2,sys_users t3 where t1.id = t2.role_id and t2.user_id=t3.id and t3.userName = #{user.userName};")
    List<SysRole> getRolesByUser(SysUser user);

}

