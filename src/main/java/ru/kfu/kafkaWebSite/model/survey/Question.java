package ru.kfu.kafkaWebSite.model.survey;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
@SequenceGenerator(name = AbstractEntity.GENERATOR, sequenceName = "questions_seq", allocationSize = 1)
public class Question extends AbstractEntity {

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private String text;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AnswerOption> answerOptions;

    @Builder.Default
    @Column(nullable = false, name = "is_required")
    private Boolean isRequired = Boolean.FALSE;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @JoinColumn(nullable = false, name = "survey_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Survey survey;

    public enum Type {
        RADIO,MULTI,INPUT;
    }

}
