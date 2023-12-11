package ru.kfu.kafkaWebSite.mappers.base;

import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;
import ru.kfu.kafkaWebSite.dto.PageableListDto;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface DtoMapper<E, D> extends Function<E, D> {

    default List<D> apply(List<E> items) {
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }
        return items
                .stream()
                .map(this)
                .collect(Collectors.toList());
    }

    default PageableListDto<D> apply(Page<E> page) {
        return PageableListDto.from(page.map(this));
    }
}
