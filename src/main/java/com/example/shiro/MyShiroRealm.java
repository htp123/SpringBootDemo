package com.example.shiro;

import com.example.bean.SysPermission;
import com.example.bean.SysRole;
import com.example.bean.SysUser;
import com.example.service.ISysRoleService;
import com.example.service.ISysUserService;
import com.example.service.impl.SysUserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/8/31.
 */
public class MyShiroRealm extends AuthorizingRealm {

@Resource
    ISysUserService sysUserService;

@Resource
    ISysRoleService sysRoleService;
    //权限校验
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser user  = (SysUser)principals.getPrimaryPrincipal();
//        for(SysRole role:user.getRoleList())
            for(SysRole role:sysUserService.getRoleListByUser(user)){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:sysRoleService.getPermissionByRole(role)){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    //身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SysUser userInfo = sysUserService.findByUsername(username);
        System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
//        ShiroCertficate certficate = principals.getPrimaryPrincipal();
//        SimplePrincipalCollection spc = new SimplePrincipalCollection()
        super.clearCachedAuthenticationInfo(principals);
    }
}
