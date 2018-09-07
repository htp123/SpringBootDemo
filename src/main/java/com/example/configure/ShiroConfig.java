package com.example.configure;

import com.example.shiro.MyFormAuthenticationFilter;
import com.example.shiro.MyShiroRealm;
import com.example.shiro.RetryLimitHashedCredentialsMatcher;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2018/8/31.
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //针对登录成功页面不跳转的问题
        Map filterMap = new LinkedHashMap();
        filterMap.put("authc",new MyFormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断
//        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接，可直接重写表单过滤器的onLoginSuccess()
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //<!-- 过滤链定义，从上向下顺序执行，一般将放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 自定义Realm创建
     * @return
     */
    @Bean
    public MyShiroRealm myShiroRealm(CredentialsMatcher credentialsMatcher){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        //将自定义的令牌set到了Realm
        myShiroRealm.setCredentialsMatcher(credentialsMatcher);
        return myShiroRealm;
    }

    /**
     * 交由SecurityManage管理
     * @return
     */
    @Bean
    @DependsOn("credentialsMatcher")
    public SecurityManager securityManager(CredentialsMatcher credentialsMatcher){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm(credentialsMatcher));
        return securityManager;
    }

    /**
     * 功能增强
     * @return
     */
    @Bean("credentialsMatcher")
    public CredentialsMatcher credentialsMatcher(){
        RetryLimitHashedCredentialsMatcher credentialsMatcher
                = new RetryLimitHashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");         //加密方式
        credentialsMatcher.setHashIterations(1);                //加密迭代次数
        credentialsMatcher.setStoredCredentialsHexEncoded(false); //编码格式
        return credentialsMatcher;
    }

    //配置AOP
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor
                = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //等价于  pom.xml+properties AOP 配置
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }


 // 设置权限不足的情况
   /* @Bean(name="simpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("DatabaseException", "databaseError");//数据库异常处理
        mappings.setProperty("UnauthorizedException","403");
        r.setExceptionMappings(mappings);  // None by default
        r.setDefaultErrorView("error");    // No default
        r.setExceptionAttribute("ex");     // Default is "exception"
        return r;
    }*/

  /*缓存方式实现，暂时先抛开缓存
    public CredentialsMatcher credentialsMatcher(CacheManager cacheManager) {
        RetryLimitHashedCredentialsMatcher credentialsMatcher
                = new RetryLimitHashedCredentialsMatcher(cacheManager);
        //加密方式
        credentialsMatcher.setHashAlgorithmName(properties.getAlgorithmName());
        //加密迭代次数
        credentialsMatcher.setHashIterations(properties.getIteration());
        //true加密用的hex编码，false用的base64编码
        credentialsMatcher.setStoredCredentialsHexEncoded(properties.getHexEncoded());
        //重新尝试的次数（自己定义的）
        credentialsMatcher.setRetryMax(properties.getRetryMax());
        return credentialsMatcher;
    }*/



 /*   @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }*/
}