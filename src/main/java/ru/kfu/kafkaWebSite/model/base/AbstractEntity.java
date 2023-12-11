package ru.kfu.kafkaWebSite.model.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import ru.kfu.kafkaWebSite.utils.HibernateUtils;

import javax.persistence.*;
import java.util.Objects;
import java.util.StringJoiner;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractEntity {

    public static final String ID_COLUMN_NAME = "id";
    public static final String GENERATOR = "seq_generator";

    @Id
    @Column(name = ID_COLUMN_NAME)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR)
    private Long id;

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !HibernateUtils.isEqualHibernateObjectClasses(this, o)) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "(", ")")
                .add("id=" + id)
                .toString();
    }
}
