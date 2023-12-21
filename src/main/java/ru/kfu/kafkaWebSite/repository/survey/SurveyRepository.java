package ru.kfu.kafkaWebSite.repository.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.survey.Survey;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findByAuthor_Id(Long authorId);
}
