package ru.fadesml.graduates.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${app.host}")
    public String host;

    public String getHost() {
        return host;
    }
}
