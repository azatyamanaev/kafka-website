package ru.kfu.kafkaWebSite.model;

// SurveyResponseEntity.java

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "survey_responses")
public class SurveyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "respondent_name")
    private String respondentName;

    @Column(name = "survey_question")
    private String surveyQuestion;

    @Column(name = "answer")
    private String answer;
}

