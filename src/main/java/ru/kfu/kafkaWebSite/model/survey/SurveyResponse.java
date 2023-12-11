package ru.kfu.kafkaWebSite.model.survey;

// SurveyResponseEntity.java

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

import javax.persistence.*;

@Getter @Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "survey_responses")
@SequenceGenerator(name = AbstractEntity.GENERATOR, sequenceName = "survey_responses_seq", allocationSize = 1)
public class SurveyResponse extends AbstractEntity {

    @Column(name = "respondent_name")
    private String respondentName;

    @Column(name = "survey_question")
    private String surveyQuestion;

    @Column(name = "answer")
    private String answer;
}

