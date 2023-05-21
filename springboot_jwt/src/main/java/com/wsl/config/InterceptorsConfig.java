package com.wsl.config;

        import com.wsl.interceptors.JWTInterceptors;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptors())
                .addPathPatterns("/user/test")//其他接口都验证
                .excludePathPatterns("/user/login");//所有用户的接口都放行
    }
}
