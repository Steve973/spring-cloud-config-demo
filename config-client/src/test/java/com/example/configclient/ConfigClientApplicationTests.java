package com.example.configclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigClientApplicationTests {

    @Value("${mongodb.url}")
    String mongodbUrl;

    @Test
    void contextLoads() {
    }

    @Test
    void mongoDbUrlBuiltProperly() {
        Assertions.assertEquals("mongodb://app1:app1pass@127.0.0.1:27017/some_database/", mongodbUrl);
    }
}
