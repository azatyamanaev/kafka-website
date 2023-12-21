package ru.kfu.kafkaWebSite.model.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.model.User;
import ru.kfu.kafkaWebSite.model.base.AbstractAuditableDeletableEntity;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "surveys")
@SequenceGenerator(name = AbstractEntity.GENERATOR, sequenceName = "surveys_seq", allocationSize = 1)
public class Survey extends AbstractAuditableDeletableEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @JoinColumn(nullable = false, name = "author_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User author;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("number")
    private List<Question> questions;

}
