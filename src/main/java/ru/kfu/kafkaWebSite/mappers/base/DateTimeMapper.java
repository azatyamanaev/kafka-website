package ru.kfu.kafkaWebSite.mappers.base;

import org.mapstruct.Mapper;
import ru.kfu.kafkaWebSite.utils.DateTimeUtils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface DateTimeMapper {

    default Long apply(final LocalDate date) {
        if (date == null) {
            return null;
        }
        return DateTimeUtils.toMillis(date);
    }

    default Long apply(final LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return DateTimeUtils.toMillis(dateTime);
    }

    default Long apply(final Instant instant) {
        if (instant == null) {
            return null;
        }
        return instant.toEpochMilli();
    }
}
