package com.miyano.enterprisecloud.configuration;

import com.miyano.enterprisecloud.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Miyano
 * @since 2020/11/12 10:07
 */
@Configuration
public class CustomWebMvcConfiguration implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor sessionInterceptor () {
        return new LoginInterceptor ();
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor (sessionInterceptor()).addPathPatterns ("/pri/**");
    }
}
