package com.nimbus.onepiece.characters.config;

import com.nimbus.onepiece.characters.observation.SimpleObservationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObservationConfig {

    @Bean
    public SimpleObservationHandler simpleObservationHandler() {
        return new SimpleObservationHandler();
    }
}
