package ru.kfu.kafkaWebSite.repository;

// SurveyResponseRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.SurveyResponse;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
}

