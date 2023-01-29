package com.example.configclient;

import com.example.configclient.config.ConfigClientConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigClientApplicationTests {

    @Autowired
    ConfigClientConfig.ClientConfig clientConfig;

    @Test
    void contextLoads() {
    }

    @Test
    void mongoDbUrlBuiltProperly() {
        Assertions.assertEquals("mongodb://app1:app1pass@127.0.0.1:27017/some_database/", clientConfig.getMongodbUrl());
    }
}
