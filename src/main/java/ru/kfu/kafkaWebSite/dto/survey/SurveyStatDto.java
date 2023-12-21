package ru.kfu.kafkaWebSite.dto.survey;

import lombok.Data;

import java.util.List;

@Data
public class SurveyStatDto {
    SurveyDto survey;
    List<RespondentResponseDto> respondentList;
}
