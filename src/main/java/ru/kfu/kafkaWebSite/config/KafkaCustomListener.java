package ru.kfu.kafkaWebSite.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.kfu.kafkaWebSite.dto.survey.SurveyResponseDto;
import ru.kfu.kafkaWebSite.service.SurveyService;
import ru.kfu.kafkaWebSite.settings.KafkaSettings;

/**
 * @author Azat Yamanaev
 * @since 23.12.2023
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaCustomListener {

    private final SurveyService service;

    @KafkaListener(topics = KafkaSettings.SURVEY_TOPIC, containerFactory = "kafkaListenerContainerFactory")
    public void writeToDb(@Payload SurveyResponseDto message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Received Message: " + message + "from partition: " + partition);
        service.saveSurveyResponse(message);
    }
}
