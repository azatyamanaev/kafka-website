package ru.kfu.kafkaWebSite.dto.survey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kfu.kafkaWebSite.dto.UserDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDto {

    private Long id;
    private String name;
    private String description;
    private UserDto author;
    private List<QuestionDto> questions;
}
