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
    private List<QuestionChoiceDto> choices;
    private Boolean isRequired;
    private Question.Type type;
}
