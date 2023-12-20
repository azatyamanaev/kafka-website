package ru.kfu.kafkaWebSite.repository.survey;

// SurveyResponseRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.survey.SurveyResponse;

import java.util.List;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
    List<SurveyResponse> findBySurvey_Id(Long surveyId);
}

