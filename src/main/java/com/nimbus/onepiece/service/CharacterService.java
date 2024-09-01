package com.nimbus.onepiece.service;

import com.nimbus.onepiece.model.Character;
import com.nimbus.onepiece.model.Crew;
import com.nimbus.onepiece.model.Faction;
import com.nimbus.onepiece.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CharacterService {

    //TODO add a persistence layer
    private static final com.nimbus.onepiece.model.Character LUFFY = com.nimbus.onepiece.model.Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
            .name("Monkey D. Luffy")
            .role(Role.CAPTAIN)
            .faction(Faction.PIRATE)
            .build();
    private static final com.nimbus.onepiece.model.Character ZORO = com.nimbus.onepiece.model.Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000002"))
            .name("Roronoa Zoro")
            .role(Role.SWORDSMAN)
            .faction(Faction.PIRATE)
            .build();
    private static final com.nimbus.onepiece.model.Character NAMI = com.nimbus.onepiece.model.Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000003"))
            .name("Nami")
            .role(Role.NAVIGATOR)
            .faction(Faction.PIRATE)
            .build();
    private static final com.nimbus.onepiece.model.Character USOPP = com.nimbus.onepiece.model.Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000004"))
            .name("Usopp")
            .role(Role.SNIPER)
            .faction(Faction.PIRATE)
            .build();
    private static final com.nimbus.onepiece.model.Character SANJI = com.nimbus.onepiece.model.Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000005"))
            .name("Vinsmoke Sanji")
            .role(Role.COOK)
            .faction(Faction.PIRATE)
            .build();
    private static final com.nimbus.onepiece.model.Character CHOPPER = com.nimbus.onepiece.model.Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000006"))
            .name("Tony Tony Chopper")
            .role(Role.DOCTOR)
            .faction(Faction.PIRATE)
            .build();
    private static final com.nimbus.onepiece.model.Character ROBIN = com.nimbus.onepiece.model.Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000007"))
            .name("Nico Robin")
            .role(Role.ARCHAEOLOGIST)  // You might want to change this to a more appropriate role like SCHOLAR
            .faction(Faction.PIRATE)
            .build();
    private static final com.nimbus.onepiece.model.Character FRANKY = com.nimbus.onepiece.model.Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000008"))
            .name("Franky")
            .role(Role.SHIPWRIGHT)
            .faction(Faction.PIRATE)
            .build();
    private static final com.nimbus.onepiece.model.Character BROOK = com.nimbus.onepiece.model.Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000009"))
            .name("Brook")
            .role(Role.MUSICIAN)
            .faction(Faction.PIRATE)
            .build();
    private static final com.nimbus.onepiece.model.Character JINBE = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000010"))
            .name("Jinbe")
            .role(Role.HELMSMAN)
            .faction(Faction.PIRATE)
            .build();
    private static final Crew STRAW_HATS = Crew.builder()
            .name("Straw Hat Pirates")
            .captain(LUFFY)
            .members(List.of(
                    LUFFY,
                    ZORO,
                    NAMI,
                    USOPP,
                    SANJI,
                    CHOPPER,
                    ROBIN,
                    FRANKY,
                    BROOK,
                    JINBE))
            .build();

    public Optional<Character> getCharacter(UUID id) {
        return STRAW_HATS.members().stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
    }

    public List<Character> getCharacters(Faction faction) {
        return STRAW_HATS.members().stream().filter(c -> c.faction() == faction).toList();
    }

    public Optional<Crew> getCrew(String name) {
        return "Straw Hat Pirates".equals(name) ? Optional.of(STRAW_HATS) : Optional.empty();
    }
}
