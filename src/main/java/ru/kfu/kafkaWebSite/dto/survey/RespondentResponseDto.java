package ru.kfu.kafkaWebSite.dto.survey;

import lombok.Data;

import java.util.Map;

@Data
public class RespondentResponseDto {
    private String respondentName;
    private String responseDate;
    private Map<Long, String> answerIdInputs;
}
