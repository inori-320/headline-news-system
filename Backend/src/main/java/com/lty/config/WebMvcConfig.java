package com.lty.config;

import com.lty.interceptors.LoginProtectedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * @author lty
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginProtectedInterceptor lpi;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(lpi).addPathPatterns("/headline/**");
    }
}
