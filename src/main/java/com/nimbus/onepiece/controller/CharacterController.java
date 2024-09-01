package com.nimbus.onepiece.controller;

import com.nimbus.onepiece.model.Character;
import com.nimbus.onepiece.model.Crew;
import com.nimbus.onepiece.model.Faction;
import com.nimbus.onepiece.model.Role;
import com.nimbus.onepiece.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Controller
public class CharacterController {

    private final CharacterService characterService;

    @QueryMapping
    public Mono<Character> character(@Argument UUID id) {
        return characterService.getCharacter(id)
                .map(Mono::just)
                .orElse(Mono.empty());
    }

    @QueryMapping
    public Flux<Character> characters(@Argument Faction faction) {
        return Flux.fromIterable(characterService.getCharacters(faction));
    }

    @QueryMapping
    public Mono<Crew> crew(@Argument String name) {
        return characterService.getCrew(name)
                .map(Mono::just)
                .orElse(Mono.empty());
    }

}
