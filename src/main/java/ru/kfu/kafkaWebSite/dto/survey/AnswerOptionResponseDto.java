package ru.kfu.kafkaWebSite.dto.survey;

import lombok.Data;

@Data
public class AnswerOptionResponseDto {
    private Long answerOptionId;
    private String text;
}
