package com.hailin.springboot.config;

import com.hailin.springboot.config.intercepter.JWTIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtIntercepter())
                .addPathPatterns("/**") //拦截
                .excludePathPatterns("/user/login","/user/register","/**/export","/**/import"); //放行

    }
    @Bean
    public JWTIntercepter jwtIntercepter(){
        return new JWTIntercepter();
    }

}
