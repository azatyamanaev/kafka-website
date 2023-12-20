package ru.kfu.kafkaWebSite.model.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.model.base.AbstractAuditableDeletableEntity;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "survey_responses")
@SequenceGenerator(name = AbstractEntity.GENERATOR, sequenceName = "survey_responses_seq", allocationSize = 1)
public class SurveyResponse extends AbstractAuditableDeletableEntity {

    @JoinColumn(nullable = false, name = "survey_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Survey survey;

    @Column(name = "respondent_name")
    private String respondentName;

    @OneToMany(mappedBy = "surveyResponse", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<QuestionResponse> questionResponses;
}

