package com.nimbus.onepiece.characters.service;

import com.nimbus.onepiece.characters.domain.Character;
import com.nimbus.onepiece.characters.domain.Faction;
import com.nimbus.onepiece.characters.domain.Role;
import com.nimbus.onepiece.characters.persistence.CharacterRepository;
import com.nimbus.onepiece.characters.persistence.records.CharacterRecord;
import io.micrometer.observation.ObservationRegistry;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public Mono<Character> getCharacter(@NonNull UUID id) {


        return characterRepository.findById(id)
                .map(CharacterService::toDomain);
    }

    public Flux<Character> getCharacters(@NonNull UUID crewId) {
        return characterRepository.findAllByCrewId(crewId)
                .map(CharacterService::toDomain);
    }

    public Flux<Character> getAllCharacters() {
        return characterRepository.findAll()
                .map(CharacterService::toDomain);
    }

    private static Character toDomain(CharacterRecord record) {
        return Character.builder()
                .id(record.id())
                .name(record.name())
                .role(Role.valueOf(record.role()))
                .faction(Faction.valueOf(record.faction()))
                .crewId(record.crewId())
                .devilFruitCode(record.devilFruitCode())
                .build();
    }
}
