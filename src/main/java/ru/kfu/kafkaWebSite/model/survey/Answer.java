package ru.kfu.kafkaWebSite.model.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.model.Respondent;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "answers")
@SequenceGenerator(name = AbstractEntity.GENERATOR, sequenceName = "answers_seq", allocationSize = 1)
public class Answer extends AbstractEntity {

    @Column
    private String text;

    @OneToMany(mappedBy = "answer")
    private List<QuestionChoice> chosen;

    @Column
    @Enumerated(EnumType.STRING)
    private Question.Type type;

    @JoinColumn(nullable = false, name = "question_id")
    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    private Question question;

    @JoinColumn(name = "respondent_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Respondent respondent;
}
