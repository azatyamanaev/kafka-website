package ru.kfu.kafkaWebSite.model.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question_responses")
public class QuestionResponse extends AbstractEntity {

    @JoinColumn(nullable = false, name = "survey_response_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SurveyResponse surveyResponse;

    @JoinColumn(nullable = false, name = "question_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Question question;

    @OneToMany(mappedBy = "questionResponse", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AnswerOptionResponse> answerOptionResponses;
}
