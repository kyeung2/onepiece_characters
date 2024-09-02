package com.nimbus.onepiece.service;

import com.nimbus.onepiece.model.Character;
import com.nimbus.onepiece.model.Faction;
import com.nimbus.onepiece.model.Role;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CharacterService {

    //TODO these would be entries in a CHARACTER table with a foreign key to
    // the CREW.ID field.
    private static final Character LUFFY = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
            .name("Monkey D. Luffy")
            .role(Role.CAPTAIN)
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();
    private static final Character ZORO = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000002"))
            .name("Roronoa Zoro")
            .role(Role.SWORDSMAN)
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();
    private static final Character NAMI = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000003"))
            .name("Nami")
            .role(Role.NAVIGATOR)
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();
    private static final Character USOPP = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000004"))
            .name("Usopp")
            .role(Role.SNIPER)
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();
    private static final Character SANJI = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000005"))
            .name("Vinsmoke Sanji")
            .role(Role.COOK)
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();
    private static final Character CHOPPER = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000006"))
            .name("Tony Tony Chopper")
            .role(Role.DOCTOR)
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();
    private static final Character ROBIN = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000007"))
            .name("Nico Robin")
            .role(Role.ARCHAEOLOGIST)  // You might want to change this to a more appropriate role like SCHOLAR
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();
    private static final Character FRANKY = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000008"))
            .name("Franky")
            .role(Role.SHIPWRIGHT)
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();
    private static final Character BROOK = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000009"))
            .name("Brook")
            .role(Role.MUSICIAN)
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();
    private static final Character JINBE = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000010"))
            .name("Jinbe")
            .role(Role.HELMSMAN)
            .faction(Faction.PIRATE)
            .crewId(CrewService.STRAW_HATS_CREW_ID)
            .build();

    private static final List<Character> ALL_CHARACTERS = List.of(LUFFY, ZORO, NAMI, USOPP, SANJI, CHOPPER, ROBIN, FRANKY, BROOK, JINBE);

    public Optional<Character> getCharacterById(@NonNull UUID id) {


        return ALL_CHARACTERS.stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
    }

    public Collection<Character> getAllCharacters() {
        return ALL_CHARACTERS;
    }

    public Collection<Character> getCharactersByCrewId(@NonNull UUID crewId) {
        return ALL_CHARACTERS.stream()
                .filter(c -> c.crewId() != null)
                .filter(c -> c.crewId().equals(crewId))
                .toList();
    }


    public Collection<Character> getCharactersByCrewIdAndRole(@NonNull UUID crewId, @NonNull Role role) {
        return ALL_CHARACTERS.stream()
                .filter(c -> c.crewId() != null)
                .filter(c -> c.crewId().equals(crewId))
                .filter(c -> c.role() == role)
                .toList();
    }
}
