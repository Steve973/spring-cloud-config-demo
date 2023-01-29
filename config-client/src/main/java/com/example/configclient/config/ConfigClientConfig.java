package com.example.configclient.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Objects;

@Configuration
@PropertySource(value = {"classpath:static/application.yaml"}, factory = YamlPropertySourceFactory.class)
@PropertySource(value = {"classpath:static/mongodbusers.yaml"}, factory = YamlPropertySourceFactory.class)
@Data
public class ConfigClientConfig {

    @Bean
    @RefreshScope
    ClientConfig clientConfig(@Value("${main-settings.property-a}") String mainPropertyA,
                              @Value("${main-settings.property-b}") String mainPropertyB,
                              @Value("${main-settings.property-c}") String mainPropertyC,
                              @Value("${main-settings.property-d}") String mainPropertyD,
                              @Value("${main-settings.override-a}") String mainPropertyOverrideA,
                              @Value("${app1-stuff.property-1}") String app1StuffProperty1,
                              @Value("${app1-stuff.property-2}") String app1StuffProperty2,
                              @Value("${app1-stuff.property-3}") String app1StuffProperty3,
                              @Value("${mongodb.url}") String mongodbUrl) {
        return new ClientConfig(mainPropertyA, mainPropertyB, mainPropertyC, mainPropertyD, mainPropertyOverrideA,
                app1StuffProperty1, app1StuffProperty2, app1StuffProperty3, mongodbUrl);
    }

    @Data
    public static class ClientConfig {
        private final String mainPropertyA;
        private final String mainPropertyB;
        private final String mainPropertyC;
        private final String mainPropertyD;
        private final String mainPropertyOverrideA;
        private final String app1StuffProperty1;
        private final String app1StuffProperty2;
        private final String app1StuffProperty3;
        private final String mongodbUrl;

        public ClientConfig(String mainPropertyA, String mainPropertyB, String mainPropertyC, String mainPropertyD,
                            String mainPropertyOverrideA, String app1StuffProperty1, String app1StuffProperty2,
                            String app1StuffProperty3, String mongodbUrl) {
            this.mainPropertyA = mainPropertyA;
            this.mainPropertyB = mainPropertyB;
            this.mainPropertyC = mainPropertyC;
            this.mainPropertyD = mainPropertyD;
            this.mainPropertyOverrideA = mainPropertyOverrideA;
            this.app1StuffProperty1 = app1StuffProperty1;
            this.app1StuffProperty2 = app1StuffProperty2;
            this.app1StuffProperty3 = app1StuffProperty3;
            this.mongodbUrl = mongodbUrl;
        }
    }
}
