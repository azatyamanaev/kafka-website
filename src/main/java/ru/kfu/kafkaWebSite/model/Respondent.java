package ru.kfu.kafkaWebSite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "respondents")
@SequenceGenerator(name = AbstractEntity.GENERATOR, sequenceName = "respondents_seq", allocationSize = 1)
public class Respondent extends AbstractEntity {

    private String name;

}
