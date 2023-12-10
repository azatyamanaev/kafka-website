package ru.kfu.kafkaWebSite.repository;

// SurveyResponseRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.repository.entity.SurveyResponseEntity;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponseEntity, Long> {
}

