package com.example.configclient.web;

import com.example.configclient.config.ConfigClientConfig;
import org.bson.Document;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    final ConfigClientConfig.ClientConfig clientConfig;

    public ConfigClientController(final ConfigClientConfig.ClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    @GetMapping(path = "/config", produces = MediaType.APPLICATION_JSON_VALUE)
    public Document getConfig() {
        return new Document("main property a", clientConfig.getMainPropertyA())
                .append("main property b", clientConfig.getMainPropertyB())
                .append("main property c", clientConfig.getMainPropertyC())
                .append("main property d", clientConfig.getMainPropertyD())
                .append("main property override a", clientConfig.getMainPropertyOverrideA())
                .append("app1 property 1", clientConfig.getApp1StuffProperty1())
                .append("app1 property 2", clientConfig.getApp1StuffProperty2())
                .append("app1 property 3", clientConfig.getApp1StuffProperty3())
                .append("MongoDB URL", clientConfig.getMongodbUrl());
    }
}
