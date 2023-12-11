package ru.kfu.kafkaWebSite.service.datasource;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class FlywayExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        final ApplicationContext applicationContext = SpringExtension.getApplicationContext(extensionContext);
        final FlywayService flywayService = applicationContext.getBean(FlywayService.class);
        flywayService.init();
    }
}
