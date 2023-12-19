package ru.kfu.kafkaWebSite.dto.survey;

import lombok.Data;

import java.util.List;

@Data
public class QuestionResponseDto {

    private Long id;
    private List<AnswerOptionResponseDto> answers;
}
