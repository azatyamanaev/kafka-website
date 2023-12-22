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

    private String producerHost;
    private String producerPort;
    private String consumerHost;
    private String consumerPort;

    @Getter
    private String consumerGroup;

    @Getter
    private String trustedPackages;

    public String getProducerConfig() {
        return producerHost + ":" + producerPort;
    }

    public String getConsumerConfig() {
        return consumerHost + ":" + consumerPort;
    }
}
