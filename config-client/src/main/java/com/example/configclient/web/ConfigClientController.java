package com.example.configclient.web;

import org.bson.Document;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    final String mainPropertyA;
    final String mainPropertyB;
    final String mainPropertyC;
    final String mainPropertyD;
    final String mainPropertyOverrideA;
    final String app1StuffProperty1;
    final String app1StuffProperty2;
    final String app1StuffProperty3;
    final String mongodbUrl;

    public ConfigClientController(
            final String mainPropertyA,
            final String mainPropertyB,
            final String mainPropertyC,
            final String mainPropertyD,
            final String mainPropertyOverrideA,
            final String app1StuffProperty1,
            final String app1StuffProperty2,
            final String app1StuffProperty3,
            final String mongodbUrl) {
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

    @GetMapping(path = "/config", produces = MediaType.APPLICATION_JSON_VALUE)
    public Document getConfig() {
        return new Document("main property a", mainPropertyA)
                .append("main property b", mainPropertyB)
                .append("main property c", mainPropertyC)
                .append("main property d", mainPropertyD)
                .append("main property override a", mainPropertyOverrideA)
                .append("app1 property 1", app1StuffProperty1)
                .append("app1 property 2", app1StuffProperty2)
                .append("app1 property 3", app1StuffProperty3)
                .append("MongoDB URL", mongodbUrl);
    }
}
