package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean   //相当于 Spring中 applicationContext.xml<bean id="" class="">
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
