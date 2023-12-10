package ru.kfu.kafkaWebSite.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyResponse {
    private String respondentName;
    private String surveyQuestion;
    private String answer;
}
