package com.zenvofurniture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins(
              
            		"http://localhost:3000",      // Add your React port
            		"http://localhost:3001",      // Add your React port
            		"http://localhost:3002",      // Add your React port
            		"http://localhost:3003",      // Add your React port
                "http://192.168.1.80:3000",
                "http://192.168.1.80:3001",
                "http://192.168.1.80:3002",    // Add your network URL
                "http://192.168.1.80:3003"    // Add your network URL
            )
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);
    }
}