package ru.kfu.kafkaWebSite.repository.survey;

// SurveyResponseRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.survey.SurveyResponse;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
}
