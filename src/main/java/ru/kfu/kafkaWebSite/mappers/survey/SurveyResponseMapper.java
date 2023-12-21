package ru.kfu.kafkaWebSite.mappers.survey;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.dto.survey.QuestionResponseDto;
import ru.kfu.kafkaWebSite.dto.survey.SurveyResponseDto;
import ru.kfu.kafkaWebSite.model.survey.QuestionResponse;
import ru.kfu.kafkaWebSite.model.survey.Survey;
import ru.kfu.kafkaWebSite.model.survey.SurveyResponse;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = {QuestionResponseMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SurveyResponseMapper {

    default SurveyResponse toSurveyResponse(SurveyResponseDto responseDto) {
        SurveyResponse surveyResponse = new SurveyResponse();
        surveyResponse.setSurvey(new Survey());
        surveyResponse.getSurvey().setId(Long.parseLong(responseDto.getSurveyId()));
        surveyResponse.setRespondentName(responseDto.getRespondentName());
        QuestionResponseMapper questionResponseMapper = new QuestionResponseMapper() {
            @Override
            public QuestionResponse toQuestionResponse(QuestionResponseDto responseDto) {
                return QuestionResponseMapper.super.toQuestionResponse(responseDto);
            }
        };
        surveyResponse.setQuestionResponses(responseDto.getQuestions().stream()
                .map(questionResponseMapper::toQuestionResponse)
                .collect(Collectors.toList()));
        return surveyResponse;
    }
}
