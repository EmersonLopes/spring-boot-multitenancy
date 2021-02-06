package com.example.springbootmultitenancy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.springbootmultitenancy.tenant.TenantInterceptor;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
 
    private final TenantInterceptor tenantInterceptor;
 
    public WebConfiguration(TenantInterceptor tenantInterceptor) {
        this.tenantInterceptor = tenantInterceptor;
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(tenantInterceptor);
    }
}