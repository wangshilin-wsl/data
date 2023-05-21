package com.wsl.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //链式编程
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能只有对应有权限的人才能访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //没有权限会默认到登录界面,需要开启登录界面
        http.formLogin();
        //注销,开启了注销功能,跳到首页
        //防止攻击，网站工具，get,post
        http.csrf().disable();//关闭csrf功能,登录失败存在的原因
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能,cookies,
        http.rememberMe().rememberMeParameter("remember");
        http.formLogin().loginPage("/toLogin").usernameParameter("username")
        .passwordParameter("password");
    }
//认证，在springboot2.1.x可以直接使用
    //密码编码：PasswordEncoder
    //在spring security5.0+新增了很多的加密方法~
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据正常应该是从数据库中读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("wsl").password(new BCryptPasswordEncoder().encode("111")).roles("vip2","vip3")
                .and().withUser("root").password(new BCryptPasswordEncoder().encode("111")).roles("vip1","vip2","vip3")
                .and().withUser("guest").password(new BCryptPasswordEncoder().encode("111")).roles("vip1");
    }
}
