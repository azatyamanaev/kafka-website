package ru.kfu.kafkaWebSite.mappers.survey;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.dto.survey.AnswerOptionResponseDto;
import ru.kfu.kafkaWebSite.model.survey.AnswerOption;
import ru.kfu.kafkaWebSite.model.survey.AnswerOptionResponse;

@Mapper(componentModel = "spring",
        uses = {},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AnswerOptionResponseMapper {

    default AnswerOptionResponse toAnswerOptionResponse(AnswerOptionResponseDto responseDto) {
        AnswerOptionResponse response = new AnswerOptionResponse();
        response.setAnswerOption(new AnswerOption());
        response.getAnswerOption().setId(responseDto.getAnswerOptionId());
        response.setText(responseDto.getText());
        return response;
    }
}
