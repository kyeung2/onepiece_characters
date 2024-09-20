package com.nimbus.onepiece.characters;

import com.nimbus.onepiece.characters.domain.Character;
import com.nimbus.onepiece.characters.domain.Crew;
import com.nimbus.onepiece.characters.domain.Faction;
import com.nimbus.onepiece.characters.domain.Role;
import lombok.experimental.UtilityClass;
import nimbus.onepiece.devilfruits.interfaces.StaticDevilFruits;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class DomainTestData {

    public static final Crew CREW_STRAW_HATS = Crew.builder()
            .id(UUID.fromString("00000000-0000-0000-0001-000000000000"))
            .name("Straw Hat Pirates")
            .members(List.of())
            .build();

    public static final Character CHARACTER_LUFFY = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
            .name("Monkey D. Luffy")
            .role(Role.CAPTAIN)
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .devilFruitCode(StaticDevilFruits.GOMU_GOMU_NO_MI.code())
            .build();
    public static final Character CHARACTER_ZORO = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000002"))
            .name("Roronoa Zoro")
            .role(Role.SWORDSMAN)
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final Character CHARACTER_NAMI = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000003"))
            .name("Nami")
            .role(Role.NAVIGATOR)
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final Character CHARACTER_USOPP = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000004"))
            .name("Usopp")
            .role(Role.SNIPER)
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final Character CHARACTER_SANJI = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000005"))
            .name("Vinsmoke Sanji")
            .role(Role.COOK)
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final Character CHARACTER_CHOPPER = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000006"))
            .name("Tony Tony Chopper")
            .role(Role.DOCTOR)
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .devilFruitCode(StaticDevilFruits.HITO_HITO_NO_MI.code())
            .build();
    public static final Character CHARACTER_ROBIN = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000007"))
            .name("Nico Robin")
            .role(Role.ARCHAEOLOGIST)  // You might want to change this to a more appropriate role like SCHOLAR
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .devilFruitCode(StaticDevilFruits.HANA_HANA_NO_MI.code())
            .build();
    public static final Character CHARACTER_FRANKY = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000008"))
            .name("Franky")
            .role(Role.SHIPWRIGHT)
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final Character CHARACTER_BROOK = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000009"))
            .name("Brook")
            .role(Role.MUSICIAN)
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .devilFruitCode(StaticDevilFruits.YOMI_YOMI_NO_MI.code())
            .build();
    public static final Character CHARACTER_JINBE = Character.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000010"))
            .name("Jinbe")
            .role(Role.HELMSMAN)
            .faction(Faction.PIRATE)
            .crewId(CREW_STRAW_HATS.id())
            .build();

    public static final List<Character> CHARACTER_ALL = List.of(
            CHARACTER_LUFFY,
            CHARACTER_ZORO,
            CHARACTER_NAMI,
            CHARACTER_USOPP,
            CHARACTER_SANJI,
            CHARACTER_CHOPPER,
            CHARACTER_ROBIN,
            CHARACTER_FRANKY,
            CHARACTER_BROOK,
            CHARACTER_JINBE);


}
