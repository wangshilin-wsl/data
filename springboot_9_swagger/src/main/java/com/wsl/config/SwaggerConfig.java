package com.wsl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    //配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的Swagger的环境
        Profiles profiles=Profiles.of("dev","test");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //
                .groupName("狂神")
                //是否启用Swagger，如果为False,则Swagger在浏览器中不能访问
                .enable(flag)
                .select()
                //RequestHandlerSelectors,配置要扫描接口的方式
                //basePackage()指定要扫描的包
                //any():扫描全部
                //none():不扫描
                //withClassAnnotation():扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.wsl.controller"))
                //paths():过滤什么路径
               // .paths(PathSelectors.ant("/wsl/**"))
                .build();
    }
    //配置Swagger信息apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("秦疆", "https://blog.kuangstudy.com/", "2634909409@qq.com");
        return new ApiInfo("狂神的SwaggerAPI文档",
                "即时再小的帆也能远航",
                "v1.0",
                "https://blog.kuangstudy.com/",
                contact,
                "Apache 2.0",
                "http://apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
