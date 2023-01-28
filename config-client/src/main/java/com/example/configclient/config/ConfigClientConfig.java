package com.example.configclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:static/application.yaml"}, factory = YamlPropertySourceFactory.class)
@PropertySource(value = {"classpath:static/mongodbusers.yaml"}, factory = YamlPropertySourceFactory.class)
public class ConfigClientConfig {

    @Bean
    String mainPropertyA(@Value("${main-settings.property-a}") String mainPropertyA) {
        return mainPropertyA;
    }

    @Bean
    String mainPropertyB(@Value("${main-settings.property-b}") String mainPropertyB) {
        return mainPropertyB;
    }

    @Bean
    String mainPropertyC(@Value("${main-settings.property-c}") String mainPropertyC) {
        return mainPropertyC;
    }

    @Bean
    String mainPropertyD(@Value("${main-settings.property-d}") String mainPropertyD) {
        return mainPropertyD;
    }

    @Bean
    String mainPropertyOverrideA(@Value("${main-settings.override-a}") String mainPropertyOverrideA) {
        return mainPropertyOverrideA;
    }

    @Bean
    String app1StuffProperty1(@Value("${app1-stuff.property-1}") String app1StuffProperty1) {
        return app1StuffProperty1;
    }

    @Bean
    String app1StuffProperty2(@Value("${app1-stuff.property-2}") String app1StuffProperty2) {
        return app1StuffProperty2;
    }

    @Bean
    String app1StuffProperty3(@Value("${app1-stuff.property-3}") String app1StuffProperty3) {
        return app1StuffProperty3;
    }

    @Bean
    String mongodbUrl(@Value("${mongodb.url}") String mongodbUrl) {
        return mongodbUrl;
    }
}
