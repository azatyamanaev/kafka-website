package ru.kfu.kafkaWebSite.repository.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.survey.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
