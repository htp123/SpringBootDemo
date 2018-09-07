package com.example.mapper;

/**
 * Created by Administrator on 2018/8/27.
 */

import com.example.bean.SysRole;
import com.example.bean.SysUser;
import com.example.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

// @Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，所以统一配置@MapperScan在扫描路径在application类中
/*@Mapper*/
@Component
public interface SysUserMapper {

    @Select("select * from sys_users where username = #{userName}")
    SysUser findByUsername(String userName);

    @Select("select t1.* from sys_roles t1,sys_users_roles t2,sys_users t3 where t1.id = t2.role_id and t2.user_id=t3.id and t3.userName = #{userName};")
    List<SysRole> getRolesByUsername(String username);


/*    @Select("select \n" +
            "id,username," +
            "case when locked='0' then '正常'\n" +
            "when locked='1' then '锁定' \n" +
            "end as locked \n" +
            "from sys_users " +
            "where 1=1 " +
            "and username = #{username}")
    List<SysUser> getUserList(String username);*/

    @Select("<script>" +
            "select \n" +
            "id,username," +
            "case when locked='0' then '正常'\n" +
            "when locked='1' then '锁定' \n" +
            "end as locked \n" +
            "from sys_users " +
            "where 1=1 " +
            "<if test=\" #{param.username} != null \"> and username like concat(#{param.username},'%')</if>" +
            "</script>")
    List<SysUser> getUserList(@Param("param") Map<String,Object> param);
}

