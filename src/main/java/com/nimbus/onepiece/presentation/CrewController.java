package com.nimbus.onepiece.presentation;

import com.nimbus.onepiece.domain.Character;
import com.nimbus.onepiece.domain.Crew;
import com.nimbus.onepiece.domain.Role;
import com.nimbus.onepiece.service.CharacterService;
import com.nimbus.onepiece.service.CrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class CrewController {

    private final CharacterService characterService;
    private final CrewService crewService;

    @QueryMapping
    public Mono<Crew> crew(@Argument UUID id) {
        return crewService.getCrew(id)
                .map(Mono::just)
                .orElse(Mono.empty());
    }

    @QueryMapping
    public Flux<Crew> allCrews() {
        return Flux.fromIterable(crewService.getAllCrews());
    }

    @SchemaMapping(typeName = "Crew", field = "members")
    public Collection<Character> members(Crew crew) {
        return characterService.getCharacters(crew.id());
    }
}
