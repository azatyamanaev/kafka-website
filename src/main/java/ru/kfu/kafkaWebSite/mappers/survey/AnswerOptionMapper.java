package ru.kfu.kafkaWebSite.mappers.survey;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.dto.survey.AnswerOptionDto;
import ru.kfu.kafkaWebSite.mappers.RespondentMapper;
import ru.kfu.kafkaWebSite.mappers.base.DtoMapper;
import ru.kfu.kafkaWebSite.mappers.base.EntityIdsMapper;
import ru.kfu.kafkaWebSite.model.survey.AnswerOption;

@Mapper(componentModel = "spring",
        uses = {EntityIdsMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AnswerOptionMapper {

    AnswerOption toAnswer(AnswerOptionDto answerDto);

    AnswerOptionDto toAnswerDto(AnswerOption answer);
}
