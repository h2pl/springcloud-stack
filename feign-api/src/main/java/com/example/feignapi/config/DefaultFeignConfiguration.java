package com.example.feignapi.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hpl
 * @date 2022/9/12 12:48
 */
@Configuration
public class DefaultFeignConfiguration {

    @Bean
    public Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }
}
