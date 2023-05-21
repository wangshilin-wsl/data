package com.wsl.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidController {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    //后台监控
    //因为springboot内置了servlet容器，所以没有web.xml，代替方法：ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登陆，设置密码与用户名
        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername","admin");//登陆的key是固定的loginUsername,loginPassword
        map.put("loginPassword","111");
        //允许谁可以访问
        map.put("allow","");
        //禁止谁能访问map.put("kuangshen","192.168.11.123");
        bean.setInitParameters(map);//初始化参数
        return bean;
    }
    //filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //可以过滤那些请求了？？
        HashMap<String, String> map = new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*");//这些东西不进行统计

        bean.setInitParameters(map);//初始化参数
        return bean;
    }
}
