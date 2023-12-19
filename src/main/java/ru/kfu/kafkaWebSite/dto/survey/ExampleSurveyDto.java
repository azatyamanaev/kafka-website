package ru.kfu.kafkaWebSite.dto.survey;

import ru.kfu.kafkaWebSite.dto.UserDto;
import ru.kfu.kafkaWebSite.model.survey.Question;

import java.util.List;

public class ExampleSurveyDto {

    public static final SurveyDto exampleSurveyDto;

    static {
        // TEST SURVEY
        UserDto author = new UserDto(1L, "example@mail.com", "Иван Иванов");
        exampleSurveyDto = SurveyDto.builder()
                .id(1L)
                .name("Благоустройство Центрального парка культуры и отдыха им. Горького")
                .description("Просим принять участие неравнодушных граждан в опросе по благоустройству ЦПКиО им. Горького")
                .author(author)
                .build();

        QuestionDto question1 = QuestionDto.builder()
                .id(1L)
                .number(1)
                .type(Question.Type.RADIO)
                .text("Возраст респондента:")
                .isRequired(true)
                .isVerifiable(false)
                .build();
        AnswerOptionDto answer11 = new AnswerOptionDto(1L,"до 18 лет;", null);
        AnswerOptionDto answer12 = new AnswerOptionDto(2L,"от 19 до 40 лет;", null);
        AnswerOptionDto answer13 = new AnswerOptionDto(3L,"от 41 до 60 лет;", null);
        AnswerOptionDto answer14 = new AnswerOptionDto(4L,"более 60 лет.", null);
        question1.setAnswerOptions(List.of(answer11, answer12, answer13, answer14));

        QuestionDto question2 = QuestionDto.builder()
                .id(2L)
                .number(2)
                .type(Question.Type.RADIO)
                .text("Пол респондента:")
                .isRequired(true)
                .isVerifiable(false)
                .build();
        AnswerOptionDto answer21 = new AnswerOptionDto(5L,"мужской;", null);
        AnswerOptionDto answer22 = new AnswerOptionDto(6L,"женский.", null);
        question2.setAnswerOptions(List.of(answer21, answer22));

        QuestionDto question3 = QuestionDto.builder()
                .id(3L)
                .number(3)
                .type(Question.Type.MULTI)
                .text("Ваше любимое место отдыха в Центральном парке культуры и отдыха им. Горького?")
                .isRequired(true)
                .isVerifiable(false)
                .build();
        AnswerOptionDto answer31 = new AnswerOptionDto(7L,"воркаут-зона;", null);
        AnswerOptionDto answer32 = new AnswerOptionDto(8L,"фонтан;", null);
        AnswerOptionDto answer33 = new AnswerOptionDto(9L,"центральная аллея парка;", null);
        AnswerOptionDto answer34 = new AnswerOptionDto(10L,"стадион;", null);
        AnswerOptionDto answer35 = new AnswerOptionDto(11L,"детская площадка.", null);
        question3.setAnswerOptions(List.of(answer31, answer32, answer33, answer34, answer35));

        QuestionDto question4 = QuestionDto.builder()
                .id(4L)
                .number(4)
                .type(Question.Type.MULTI)
                .text("Какой для Вас наиболее предпочтительный СИНТЕТИЧЕСКИЙ материал, который может использоваться в благоустройстве воркаут-площадки?")
                .isRequired(true)
                .isVerifiable(false)
                .build();
        AnswerOptionDto answer41 = new AnswerOptionDto(11L,"брусчатка;", null);
        AnswerOptionDto answer42 = new AnswerOptionDto(12L,"кирпич;", null);
        AnswerOptionDto answer43 = new AnswerOptionDto(13L,"металл;", null);
        AnswerOptionDto answer44 = new AnswerOptionDto(14L,"прорезиненные покрытия.", null);
        question4.setAnswerOptions(List.of(answer41, answer42, answer43, answer44));

        QuestionDto question5 = QuestionDto.builder()
                .id(5L)
                .number(5)
                .type(Question.Type.INPUT)
                .text("Ваши предложения по благоустройству парка:")
                .isRequired(true)
                .isVerifiable(false)
                .build();
        AnswerOptionDto answer51 = new AnswerOptionDto(15L,null, null);
        question5.setAnswerOptions(List.of(answer51));

        exampleSurveyDto.setQuestions(List.of(question1, question2, question3, question4, question5));
    }
}
