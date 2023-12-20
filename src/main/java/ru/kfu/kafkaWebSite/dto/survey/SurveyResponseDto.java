package ru.kfu.kafkaWebSite.dto.survey;

import lombok.Data;

import java.util.List;

@Data
public class SurveyResponseDto {

    private String surveyId;
    private String respondentName;
    private List<QuestionResponseDto> questions;
}
