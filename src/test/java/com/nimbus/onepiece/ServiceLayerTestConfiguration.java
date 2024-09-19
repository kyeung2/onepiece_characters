package com.nimbus.onepiece;

import com.nimbus.onepiece.characters.service.CharacterService;
import com.nimbus.onepiece.characters.service.CrewService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@TestConfiguration
public class ServiceLayerTestConfiguration {

    @Bean
    CrewService crewService() {
        CrewService mock = Mockito.mock(CrewService.class);
        when(mock.getCrew(DomainTestData.CREW_STRAW_HATS.id()))
                .thenReturn(Mono.just(DomainTestData.CREW_STRAW_HATS));

        return mock;
    }

    @Bean
    CharacterService characterService() {
        CharacterService mock = Mockito.mock(CharacterService.class);
        when(mock.getCharacters(DomainTestData.CREW_STRAW_HATS.id()))
                .thenReturn(Flux.fromIterable(DomainTestData.CHARACTER_ALL));

        return mock;
    }
}
