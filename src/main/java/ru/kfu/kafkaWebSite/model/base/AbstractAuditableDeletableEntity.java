package ru.kfu.kafkaWebSite.model.base;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableDeletableEntity extends AbstractEntity {

    @CreatedDate
    @Type(type = "java.time.Instant")
    private Instant createTime;


    @Builder.Default
    @Column(nullable = false)
    private Boolean deleted = Boolean.FALSE;
}
