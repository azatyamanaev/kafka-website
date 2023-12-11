package ru.kfu.kafkaWebSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kfu.kafkaWebSite.model.Respondent;

public interface RespondentRepository extends JpaRepository<Respondent, Long> {
}
