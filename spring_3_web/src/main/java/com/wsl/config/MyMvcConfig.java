package com.wsl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//如果你想自定义一些定制化的功能，只要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配
//扩展springmvc,官方建议我们这样做
@Configuration
//@EnableWebMvc//这玩意就是导入一个类：DelegatingWebMvcConfiguration:从容器中获取所有的webmvcconfig
public class MyMvcConfig implements WebMvcConfigurer {
    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }
    //自定义国际化组件就生效了
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).
                addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/css/**"
        ,"/js/**","/img/**");
    }
}

