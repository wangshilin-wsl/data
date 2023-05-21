package com.wsl.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("l");
        Locale locale=Locale.getDefault();//如果没有就是用默认的
        //如果请求的连接携带了国际化的参数
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            //国家，地区
            System.out.println("423432");
            locale= new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
