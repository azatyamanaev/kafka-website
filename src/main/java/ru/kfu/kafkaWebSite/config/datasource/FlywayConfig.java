package ru.kfu.kafkaWebSite.config.datasource;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.kfu.kafkaWebSite.settings.FlywaySettings;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class FlywayConfig {

    private final FlywaySettings flywaySettings;

    @Bean
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
                .outOfOrder(true)
                .baselineOnMigrate(true)
                .dataSource(dataSource)
                .locations(flywaySettings.getPath())
                .load();
    }
}
