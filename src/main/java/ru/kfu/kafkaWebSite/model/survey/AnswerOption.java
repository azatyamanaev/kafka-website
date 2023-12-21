package ru.kfu.kafkaWebSite.model.survey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answer_options")
@SequenceGenerator(name = AbstractEntity.GENERATOR, sequenceName = "answer_options_seq", allocationSize = 1)
public class AnswerOption extends AbstractEntity {

    @Column
    private String text;

    @Builder.Default
    @Column(name = "is_correct")
    private Boolean isCorrect = Boolean.FALSE;

    @JoinColumn(nullable = false, name = "question_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;
}
