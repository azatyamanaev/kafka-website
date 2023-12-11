package ru.kfu.kafkaWebSite.repository.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.survey.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
