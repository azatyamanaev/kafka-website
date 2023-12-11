package ru.kfu.kafkaWebSite.mappers.survey;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.dto.survey.AnswerDto;
import ru.kfu.kafkaWebSite.mappers.RespondentMapper;
import ru.kfu.kafkaWebSite.mappers.base.DtoMapper;
import ru.kfu.kafkaWebSite.mappers.base.EntityIdsMapper;
import ru.kfu.kafkaWebSite.model.survey.Answer;

@Mapper(componentModel = "spring",
        uses = {EntityIdsMapper.class,
                QuestionChoiceMapper.class,
                RespondentMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AnswerMapper extends DtoMapper<Answer, AnswerDto> {
}
