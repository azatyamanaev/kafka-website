package ru.kfu.kafkaWebSite.service;

import ru.kfu.kafkaWebSite.dto.survey.SurveyDto;
import ru.kfu.kafkaWebSite.dto.survey.SurveyResponseDto;
import ru.kfu.kafkaWebSite.dto.survey.SurveyStatDto;
import ru.kfu.kafkaWebSite.model.User;

import java.util.List;

public interface SurveyService {

    void createSurvey(SurveyDto surveyDto, User author);

    SurveyDto getSurveyDtoById(Long surveyId);

    List<SurveyDto> getSurveysByAuthorId(Long userId);

    void saveSurveyResponse(SurveyResponseDto surveyResponseDto);

    SurveyStatDto getSurveyStatDto(Long surveyId, Long authorId);
}
