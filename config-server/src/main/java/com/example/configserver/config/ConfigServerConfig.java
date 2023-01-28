package com.example.configserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigServerConfig {

    @Value("${app.name}")
    String appName;

    @Value("${app.description}")
    String appDescription;
}
