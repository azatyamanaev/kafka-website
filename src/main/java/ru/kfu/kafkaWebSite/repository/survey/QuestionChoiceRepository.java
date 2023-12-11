package ru.kfu.kafkaWebSite.repository.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.survey.QuestionChoice;

public interface QuestionChoiceRepository extends JpaRepository<QuestionChoice, Long> {
}
