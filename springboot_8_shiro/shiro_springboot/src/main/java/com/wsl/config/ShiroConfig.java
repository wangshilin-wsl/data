package com.wsl.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        /*
        * anon:无需认证就可以访问
        * authc:必须认证了才能访问
        * user:必须拥有，记住我功能才能用
        * perms:拥有对某个资源的权限才能访问
        * role:拥有某个角色权限才能访问
        * */
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        //授权,正常情况下，会跳到未授权页面
        linkedHashMap.put("/user/add","perms[user:add]");
        linkedHashMap.put("/user/update","perms[user:update]");
        linkedHashMap.put("/user/*","anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauth");
        return shiroFilterFactoryBean;
    }
    //DefaultWebSecurityManager
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联userRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }    //创建realm对象，需要自定义
    @Bean(name="userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
    //整合ShiroDialect:用来整合shiro和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
