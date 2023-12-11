package ru.kfu.kafkaWebSite.repository.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.survey.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
