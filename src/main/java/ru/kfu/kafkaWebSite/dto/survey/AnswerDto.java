package ru.kfu.kafkaWebSite.dto.survey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kfu.kafkaWebSite.dto.RespondentDto;
import ru.kfu.kafkaWebSite.model.survey.Question;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private Long id;
    private String text;
    private List<AnswerOptionResponseDto> chosen;
    private Question.Type type;
    private RespondentDto respondent;
}
