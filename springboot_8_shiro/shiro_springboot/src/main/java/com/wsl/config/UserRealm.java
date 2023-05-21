package com.wsl.config;

import com.wsl.pojo.User;
import com.wsl.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserServiceImpl userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权！！！");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //拿到当前登录的对象
        Subject subject= SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();//拿到user对象
        info.addStringPermission(currentUser.getPerms());
        return info;
    }
//认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证！！！");
        //用户名，密码，数据库中取

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user = userService.queryUserByName(userToken.getUsername());
        if(user==null){
            return null;
        }
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute("loginUser",user);
        //可以加密：MD5,MD5盐值加密
        //密码认证，shiro做,加密了
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");//将user存入，方便授权使用
    }
}
