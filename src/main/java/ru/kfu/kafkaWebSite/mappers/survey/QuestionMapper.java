package ru.kfu.kafkaWebSite.mappers.survey;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.dto.survey.QuestionDto;
import ru.kfu.kafkaWebSite.mappers.base.DtoMapper;
import ru.kfu.kafkaWebSite.mappers.base.EntityIdsMapper;
import ru.kfu.kafkaWebSite.model.survey.Question;

@Mapper(componentModel = "spring",
        uses = {EntityIdsMapper.class,
                AnswerOptionMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface QuestionMapper {

    Question toQuestion(QuestionDto questionDto);

    QuestionDto toQuestionDto(Question question);
}
