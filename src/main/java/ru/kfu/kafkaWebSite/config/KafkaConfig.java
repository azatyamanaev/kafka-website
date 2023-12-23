package ru.kfu.kafkaWebSite.config;


import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.kfu.kafkaWebSite.dto.survey.SurveyResponseDto;
import ru.kfu.kafkaWebSite.settings.KafkaSettings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    private final KafkaSettings settings;

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, settings.getBrokerConfig());

        return new KafkaAdmin(configProps);
    }

    @Bean
    public NewTopic surveyTopic() {
        return TopicBuilder
                .name(KafkaSettings.SURVEY_TOPIC)
                .replicas(settings.getSurveyReplicas())
                .partitions(settings.getSurveyPartitions())
                .build();
    }

    @Bean
    public ProducerFactory<String, SurveyResponseDto> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, settings.getBrokerConfig());
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, SurveyResponseDto> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaConsumer<String, SurveyResponseDto> surveyConsumer() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, settings.getBrokerConfig());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, settings.getConsumerGroup());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, settings.getTrustedPackages());

        KafkaConsumer<String, SurveyResponseDto> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(List.of(KafkaSettings.SURVEY_TOPIC));
        return consumer;
    }
}

