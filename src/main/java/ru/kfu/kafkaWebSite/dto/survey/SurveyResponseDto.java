package ru.kfu.kafkaWebSite.dto.survey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyResponseDto {

    private Long id;
    private String respondentName;
    private String surveyQuestion;
    private String answer;
}
