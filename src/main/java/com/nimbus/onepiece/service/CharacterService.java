package com.nimbus.onepiece.service;

import com.nimbus.onepiece.domain.Character;
import com.nimbus.onepiece.domain.Faction;
import com.nimbus.onepiece.domain.Role;
import com.nimbus.onepiece.persistence.CharacterRepository;
import com.nimbus.onepiece.persistence.records.CharacterRecord;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public Optional<Character> getCharacter(@NonNull UUID id) {
        return characterRepository.findCharacterById(id)
                .map(CharacterService::toDomain);
    }

    public Collection<Character> getCharacters(@NonNull UUID crewId) {
        return characterRepository.findAllByCrewId(crewId)
                .stream()
                .map(CharacterService::toDomain)
                .toList();
    }

        public Collection<Character> getCharactersByCrewIdAndRole(@NonNull UUID crewId, @NonNull Role role) {

            return characterRepository.findAllByCrewIdAndRole(crewId,role)
                    .stream()
                    .map(CharacterService::toDomain)
                    .toList();
    }

    public Collection<Character> getAllCharacters() {
        return characterRepository.findAll()
                .stream()
                .map(CharacterService::toDomain)
                .toList();
    }

    private static Character toDomain(CharacterRecord record) {
        return Character.builder()
                .id(record.id())
                .name(record.name())
                .role(Role.valueOf(record.role()))
                .faction(Faction.valueOf(record.faction()))
                .crewId(record.crewId())
                .build();
    }
}
