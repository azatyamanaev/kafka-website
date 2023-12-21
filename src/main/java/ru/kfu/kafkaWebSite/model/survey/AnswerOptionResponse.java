package ru.kfu.kafkaWebSite.model.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answer_option_responses")
@SequenceGenerator(name = AbstractEntity.GENERATOR, sequenceName = "answer_option_responses_seq", allocationSize = 1)
public class AnswerOptionResponse extends AbstractEntity {

    @Column
    private String text;

    @JoinColumn(nullable = false, name = "question_response_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QuestionResponse questionResponse;

    @JoinColumn(nullable = false, name = "answer_option_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AnswerOption answerOption;
}
