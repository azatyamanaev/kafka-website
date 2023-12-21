package ru.kfu.kafkaWebSite.dto.survey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kfu.kafkaWebSite.model.survey.Question;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private Long id;
    private Integer number;
    private String text;
    private Boolean isRequired;
    private Boolean isVerifiable;
    private Question.Type type;
    private List<AnswerOptionDto> answerOptions;
}
