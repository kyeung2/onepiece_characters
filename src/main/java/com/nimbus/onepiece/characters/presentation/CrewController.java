package com.nimbus.onepiece.characters.presentation;

import com.nimbus.onepiece.characters.domain.Character;
import com.nimbus.onepiece.characters.domain.Crew;
import com.nimbus.onepiece.characters.service.CharacterService;
import com.nimbus.onepiece.characters.service.CrewService;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CrewController {

    private final CharacterService characterService;
    private final CrewService crewService;
    private final ObservationRegistry observationRegistry;


    @QueryMapping
    public Mono<Crew> crew(@Argument UUID id) {
        // one time instrumentation of the code.
        return Observation.createNotStarted("crew", this.observationRegistry)
                .observe(() -> crewService.getCrew(id));
    }

    @QueryMapping
    public Flux<Crew> allCrews() {
        return crewService.getAllCrews();
    }

    @SchemaMapping(typeName = "Crew", field = "members")
    public Flux<Character> members(Crew crew) {
        return characterService.getCharacters(crew.id());
    }
}
