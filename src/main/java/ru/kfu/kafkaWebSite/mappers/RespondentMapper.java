package ru.kfu.kafkaWebSite.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.dto.RespondentDto;
import ru.kfu.kafkaWebSite.mappers.base.DtoMapper;
import ru.kfu.kafkaWebSite.mappers.base.EntityIdsMapper;
import ru.kfu.kafkaWebSite.model.Respondent;

@Mapper(componentModel = "spring",
        uses = EntityIdsMapper.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RespondentMapper extends DtoMapper<Respondent, RespondentDto> {
}
