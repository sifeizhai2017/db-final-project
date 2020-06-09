package com.shnu.work.config;

import com.shnu.work.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Shinomiya Kaguya
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new LoginInterceptor());
        interceptorRegistration.excludePathPatterns("/**/*.css",
                "/**/*.jpeg",
                "/**/*.jpg",
                "/**/*.js",
                "/**/*.png",
                "/**/*.woff",
                "/index");
        interceptorRegistration.excludePathPatterns("/adminLogin",
                "/login/**",
                "/register/",
                "/userLogin/",
                ResourceUtils.CLASSPATH_URL_PREFIX + "/static/",
                ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
        interceptorRegistration.addPathPatterns("/**");
    }
}