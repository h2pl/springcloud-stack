package com.example.userservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author hpl
 * @date 2022/9/12 11:17
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class NacosConfig {
    private String dateformat;
    private String shareEnv;
}
