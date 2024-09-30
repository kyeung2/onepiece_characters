package com.nimbus.onepiece.characters.presentation;

import com.nimbus.onepiece.characters.domain.Character;
import com.nimbus.onepiece.characters.domain.Crew;
import com.nimbus.onepiece.characters.service.CharacterService;
import com.nimbus.onepiece.characters.service.CrewService;
import com.nimbus.onepiece.characters.service.DevilFruitService;
import com.nimbus.onepiece.devilfruits.interfaces.dto.DevilFruitDto;
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
public class CharacterController {

    private final CharacterService characterService;
    private final CrewService crewService;
    private final DevilFruitService devilFruitService;


    @QueryMapping
    public Mono<Character> character(@Argument UUID id) {
        return characterService.getCharacter(id);
    }

    @QueryMapping
    public Flux<Character> allCharacters() {
        return characterService.getAllCharacters();
    }

    @SchemaMapping(typeName = "Character", field = "crew")
    public Mono<Crew> crewForCharacter(Character character) {
        return crewService.getCrew(character.crewId());
    }

    @SchemaMapping(typeName = "Character", field = "devilFruit")
    public Mono<DevilFruitDto> devilFruitForCharacter(Character character) {
        return devilFruitService.getDevilFruit(character.devilFruitCode());
    }
}
