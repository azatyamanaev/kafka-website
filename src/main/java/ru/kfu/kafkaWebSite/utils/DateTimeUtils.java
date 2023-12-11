package ru.kfu.kafkaWebSite.utils;

import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.time.*;
import java.util.Optional;

public interface DateTimeUtils {

    static Instant calculateResetInstant(@NonNull ZoneId zoneId, @NonNull Instant today) {
        return today.atZone(zoneId)
                .toLocalDate()
                .atStartOfDay(zoneId)
                .plusDays(1)
                .toInstant();
    }

    static Instant dayStartAtZone(@NonNull ZoneId zoneId, @NonNull Instant today) {
        return today.atZone(zoneId)
                .toLocalDate()
                .atStartOfDay(zoneId)
                .toInstant();
    }

    static Long toMillis(@Nullable LocalDateTime dateTime) {
        return Optional.ofNullable(dateTime)
                .map(dt -> dt.atZone(ZoneId.systemDefault()))
                .map(ZonedDateTime::toInstant)
                .map(Instant::toEpochMilli)
                .orElse(null);
    }

    static Long toMillis(@Nullable LocalDate date) {
        return Optional.ofNullable(date)
                .map(dt -> dt.atStartOfDay(ZoneId.systemDefault()))
                .map(ZonedDateTime::toInstant)
                .map(Instant::toEpochMilli)
                .orElse(null);
    }
}

