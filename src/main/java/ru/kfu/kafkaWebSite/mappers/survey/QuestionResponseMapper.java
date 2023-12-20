package ru.kfu.kafkaWebSite.mappers.survey;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.dto.survey.AnswerOptionResponseDto;
import ru.kfu.kafkaWebSite.dto.survey.QuestionResponseDto;
import ru.kfu.kafkaWebSite.model.survey.AnswerOptionResponse;
import ru.kfu.kafkaWebSite.model.survey.Question;
import ru.kfu.kafkaWebSite.model.survey.QuestionResponse;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {AnswerOptionResponseMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface QuestionResponseMapper {

    default QuestionResponse toQuestionResponse(QuestionResponseDto responseDto) {
        QuestionResponse questionResponse = new QuestionResponse();
        questionResponse.setQuestion(new Question());
        questionResponse.getQuestion().setId(responseDto.getQuestionId());
        AnswerOptionResponseMapper answerOptionResponseMapper = new AnswerOptionResponseMapper() {
            @Override
            public AnswerOptionResponse toAnswerOptionResponse(AnswerOptionResponseDto responseDto) {
                return AnswerOptionResponseMapper.super.toAnswerOptionResponse(responseDto);
            }
        };
        questionResponse.setAnswerOptionResponses(responseDto.getAnswers().stream()
                .map(answerOptionResponseMapper::toAnswerOptionResponse)
                .collect(Collectors.toList()));
        return questionResponse;
    }
}
