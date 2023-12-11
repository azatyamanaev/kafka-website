package ru.kfu.kafkaWebSite.mappers.base;

import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.model.base.AbstractEntity;

@Mapper(componentModel = "spring")
public interface EntityIdsMapper {

    default Long entityToId(AbstractEntity entity) {
        if (entity == null) return null;
        return entity.getId();
    }
}
