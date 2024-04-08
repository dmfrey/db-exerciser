package com.broadcom.springconsulting.dbexerciser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

@Configuration
public class TimeRepositoryConfig {

    @Bean
    BeforeConvertCallback<TimeLog> beforeConvertCallback() {

        return (time) -> {
            if (time.id == null) {
                time.id = UUID.randomUUID().toString();
            }
            return time;
        };

    }

}
