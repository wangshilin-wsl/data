package wsl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import wsl.pojo.User;

@Configuration//这个也会被spring容器托管，注册到容器中，因为它本来就是一个component，@configuration代表这是一个配置类，就和我们之前 看的beans.xml是一样的
@ComponentScan("wsl.pojo")
@Import(SecondConfig.class)//就如同xml中引入别的xml文件
public class MyConfig {
    //注册一个bean，就相当于之前写的一个bean标签
    //这个方法的名字，就相当于bean标签中的id 属性
    //这个方法的返回值，就相当于bean标签中的class属性
    @Bean
    public User getUser(){
        return new User();
    }
}
