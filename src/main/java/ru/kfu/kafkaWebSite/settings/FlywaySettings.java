package ru.kfu.kafkaWebSite.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.flyway")
public class FlywaySettings {

    private boolean generationEnabled;
    private String locationPrefix = "classpath:";
    private String location = "db/migration";

    public String getPath() {
        return locationPrefix + location;
    }

}
