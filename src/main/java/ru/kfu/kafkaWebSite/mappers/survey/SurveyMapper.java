package ru.kfu.kafkaWebSite.mappers.survey;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.dto.survey.SurveyDto;
import ru.kfu.kafkaWebSite.mappers.UserMapper;
import ru.kfu.kafkaWebSite.mappers.base.DtoMapper;
import ru.kfu.kafkaWebSite.mappers.base.EntityIdsMapper;
import ru.kfu.kafkaWebSite.model.survey.Survey;

@Mapper(componentModel = "spring",
        uses = {EntityIdsMapper.class,
                UserMapper.class,
                QuestionMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SurveyMapper {

    Survey toSurvey(SurveyDto surveyDto);

    SurveyDto toSurveyDto(Survey survey);
}
