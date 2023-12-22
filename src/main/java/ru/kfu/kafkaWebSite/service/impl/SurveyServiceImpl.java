package ru.kfu.kafkaWebSite.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.kfu.kafkaWebSite.dto.survey.RespondentResponseDto;
import ru.kfu.kafkaWebSite.dto.survey.SurveyDto;
import ru.kfu.kafkaWebSite.dto.survey.SurveyResponseDto;
import ru.kfu.kafkaWebSite.dto.survey.SurveyStatDto;
import ru.kfu.kafkaWebSite.mappers.survey.SurveyMapper;
import ru.kfu.kafkaWebSite.mappers.survey.SurveyResponseMapper;
import ru.kfu.kafkaWebSite.model.User;
import ru.kfu.kafkaWebSite.model.survey.QuestionResponse;
import ru.kfu.kafkaWebSite.model.survey.Survey;
import ru.kfu.kafkaWebSite.model.survey.SurveyResponse;
import ru.kfu.kafkaWebSite.repository.survey.SurveyRepository;
import ru.kfu.kafkaWebSite.repository.survey.SurveyResponseRepository;
import ru.kfu.kafkaWebSite.service.SurveyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;
    private final SurveyResponseRepository surveyResponseRepository;
    private final SurveyMapper surveyMapper;
    private final SurveyResponseMapper surveyResponseMapper;

    public SurveyServiceImpl(SurveyMapper surveyMapper, SurveyRepository surveyRepository, SurveyResponseRepository surveyResponseRepository, SurveyResponseMapper surveyResponseMapper) {
        this.surveyMapper = surveyMapper;
        this.surveyRepository = surveyRepository;
        this.surveyResponseRepository = surveyResponseRepository;
        this.surveyResponseMapper = surveyResponseMapper;
    }

    @Override
    public void createSurvey(SurveyDto surveyDto, User author) {
        Survey survey = surveyMapper.toSurvey(surveyDto);
        survey.setAuthor(author);
        setRelations(survey);
        surveyRepository.save(survey);
    }

    @Override
    public SurveyDto getSurveyDtoById(Long surveyId) {
        return surveyMapper.toSurveyDto(surveyRepository.getById(surveyId));
    }

    @Override
    public List<SurveyDto> getSurveysByAuthorId(Long authorId) {
        return surveyRepository.findByAuthor_Id(authorId).stream()
                .map(surveyMapper::toSurveyDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SurveyDto> getAll() {
        return surveyRepository.findAll().stream()
                .map(surveyMapper::toSurveyDto)
                .collect(Collectors.toList());
    }

    @KafkaListener(topics = "surveyResponses", groupId = "group_id")
    @Override
    public void saveSurveyResponse(SurveyResponseDto surveyResponseDto) {
        SurveyResponse surveyResponse = surveyResponseMapper.toSurveyResponse(surveyResponseDto);
        setRelations(surveyResponse);
        surveyResponseRepository.save(surveyResponse);
    }

    @Override
    public SurveyStatDto getSurveyStatDto(Long surveyId, Long authorId) {
        SurveyStatDto statDto = new SurveyStatDto();
        SurveyDto surveyDto = getSurveyDtoById(surveyId);
        if (!surveyDto.getAuthor().getId().equals(authorId)) {
            throw new IllegalStateException("Невозможно смотреть статистику чужих опросов");
        }
        statDto.setSurvey(surveyDto);

        List<SurveyResponse> surveyResponses = surveyResponseRepository.findBySurvey_Id(surveyId);
        List<RespondentResponseDto> respondentList = new ArrayList<>();
        surveyResponses.forEach(surveyResponse -> {
            RespondentResponseDto respondentResponse = new RespondentResponseDto();
            respondentResponse.setRespondentName(surveyResponse.getRespondentName());
            Map<Long, String> answerIdInputs = surveyResponse.getQuestionResponses().stream()
                    .map(QuestionResponse::getAnswerOptionResponses)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toMap(
                            aor -> aor.getAnswerOption().getId(),
                            aor -> Optional.ofNullable(aor.getText()).orElse("")
                    ));
            respondentResponse.setAnswerIdInputs(answerIdInputs);
            respondentList.add(respondentResponse);
        });
        statDto.setRespondentList(respondentList);
        return statDto;
    }

    private void setRelations(Survey survey) {
        survey.getQuestions().forEach(question -> {
            question.setSurvey(survey);
            question.getAnswerOptions().forEach(answerOption -> answerOption.setQuestion(question));
        });
    }

    private void setRelations(SurveyResponse survey) {
        survey.getQuestionResponses().forEach(question -> {
            question.setSurveyResponse(survey);
            question.getAnswerOptionResponses().forEach(answerOption -> answerOption.setQuestionResponse(question));
        });
    }
}
