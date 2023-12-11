package ru.kfu.kafkaWebSite.config.datasource;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.domain.EntityScanPackages;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.persistenceunit.DefaultPersistenceUnitManager;

import javax.persistence.spi.PersistenceUnitInfo;

import static org.hibernate.cfg.AvailableSettings.*;
import static org.hibernate.cfg.AvailableSettings.PHYSICAL_NAMING_STRATEGY;

@Configuration
@EnableJpaAuditing
@EntityScan("ru.kfu.kafkaWebSite.model")
@AutoConfigureAfter({HibernateJpaAutoConfiguration.class})
public class HibernateJPAConfig {

    @Bean
    public EntityScanPackages entityScanPackages(BeanFactory beanFactory) {
        return EntityScanPackages.get(beanFactory);
    }

    @Bean
    public Metadata getMetadata(StandardServiceRegistry standardServiceRegistry,
                                PersistenceUnitInfo persistenceUnitInfo) {
        final var metadataSources = new MetadataSources(standardServiceRegistry);
        final var managedClassNames = persistenceUnitInfo.getManagedClassNames();
        for (var managedClassName : managedClassNames) {
            metadataSources.addAnnotatedClassName(managedClassName);
        }
        return metadataSources.buildMetadata();
    }

    @Bean
    public StandardServiceRegistry getStandardServiceRegistry(JpaProperties jpaProperties,
                                                              DataSourceProperties dataSourceProperties) {
        final var properties = jpaProperties.getProperties();
        return new StandardServiceRegistryBuilder()
                .applySettings(properties)
                .applySetting(USER, dataSourceProperties.getUsername())
                .applySetting(PASS, dataSourceProperties.getPassword())
                .applySetting(URL, dataSourceProperties.getUrl())
                .applySetting(DRIVER, dataSourceProperties.getDriverClassName())
                .applySetting(IMPLICIT_NAMING_STRATEGY, SpringImplicitNamingStrategy.class.getCanonicalName())
                .applySetting(PHYSICAL_NAMING_STRATEGY, SpringPhysicalNamingStrategy.class.getCanonicalName())
                .build();
    }

    @Bean
    public PersistenceUnitInfo getPersistenceUnitInfo(EntityScanPackages entityScanPackages) {
        final var packagesToScan = entityScanPackages.getPackageNames();
        final var persistenceUnitManager = new DefaultPersistenceUnitManager();
        String[] packagesToScanArr = packagesToScan.toArray(new String[0]);
        persistenceUnitManager.setPackagesToScan(packagesToScanArr);
        persistenceUnitManager.afterPropertiesSet();
        return persistenceUnitManager.obtainDefaultPersistenceUnitInfo();
    }

    @Bean
    @Primary
    public AsyncTaskExecutor asyncTaskExecutor() {
        return new TaskSchedulerBuilder()
                .poolSize(2)
                .build();
    }
}