package com.nimbus.onepiece.controller;

import com.nimbus.onepiece.model.Character;
import com.nimbus.onepiece.model.Crew;
import com.nimbus.onepiece.model.Role;
import com.nimbus.onepiece.service.CharacterService;
import com.nimbus.onepiece.service.CrewService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;
    private final CrewService crewService;

    @QueryMapping
    public Mono<Character> character(@Argument UUID id) {
        return characterService.getCharacterById(id)
                .map(Mono::just)
                .orElse(Mono.empty());
    }

    @QueryMapping
    public Flux<Character> allCharacters() {
        return Flux.fromIterable(characterService.getAllCharacters());
    }

    @SchemaMapping(typeName = "Character", field = "crew")
    public Crew crewForCharacter(Character character) {
        return crewService.getCrewById(character.crewId()).orElse(null);
    }
}
