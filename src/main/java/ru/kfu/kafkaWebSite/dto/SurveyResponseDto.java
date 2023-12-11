package ru.kfu.kafkaWebSite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyResponseDto {
    private String respondentName;
    private String surveyQuestion;
    private String answer;
}
