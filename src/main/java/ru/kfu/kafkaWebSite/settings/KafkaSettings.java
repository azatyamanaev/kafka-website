package ru.kfu.kafkaWebSite.settings;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Azat Yamanaev
 * @since 22.12.2023
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "app.kafka")
public class KafkaSettings {

    public final static String SURVEY_TOPIC = "survey_responses";

    private String brokerConfig;
    private String consumerGroup;
    private String trustedPackages;
}
