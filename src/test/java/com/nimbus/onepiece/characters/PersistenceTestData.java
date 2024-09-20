package com.nimbus.onepiece.characters;

import com.nimbus.onepiece.characters.domain.Faction;
import com.nimbus.onepiece.characters.domain.Role;
import com.nimbus.onepiece.characters.persistence.records.CharacterRecord;
import com.nimbus.onepiece.characters.persistence.records.CrewRecord;
import lombok.experimental.UtilityClass;
import nimbus.onepiece.devilfruits.interfaces.StaticDevilFruits;

import java.util.List;
import java.util.UUID;

@UtilityClass
public class PersistenceTestData {

    public static final CrewRecord CREW_STRAW_HATS = CrewRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0001-000000000000"))
            .name("Straw Hat Pirates")
            .build();

    public static final CharacterRecord CHARACTER_LUFFY = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000001"))
            .name("Monkey D. Luffy")
            .role(Role.CAPTAIN.name())
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .devilFruitCode(StaticDevilFruits.GOMU_GOMU_NO_MI.code())
            .build();
    public static final CharacterRecord CHARACTER_ZORO = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000002"))
            .name("Roronoa Zoro")
            .role(Role.SWORDSMAN.name())
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final CharacterRecord CHARACTER_NAMI = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000003"))
            .name("Nami")
            .role(Role.NAVIGATOR.name())
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final CharacterRecord CHARACTER_USOPP = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000004"))
            .name("Usopp")
            .role(Role.SNIPER.name())
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final CharacterRecord CHARACTER_SANJI = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000005"))
            .name("Vinsmoke Sanji")
            .role(Role.COOK.name())
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final CharacterRecord CHARACTER_CHOPPER = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000006"))
            .name("Tony Tony Chopper")
            .role(Role.DOCTOR.name())
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .devilFruitCode(StaticDevilFruits.HITO_HITO_NO_MI.code())
            .build();
    public static final CharacterRecord CHARACTER_ROBIN = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000007"))
            .name("Nico Robin")
            .role(Role.ARCHAEOLOGIST.name())  // You might want to change this to a more appropriate role like SCHOLAR
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .devilFruitCode(StaticDevilFruits.HANA_HANA_NO_MI.code())
            .build();
    public static final CharacterRecord CHARACTER_FRANKY = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000008"))
            .name("Franky")
            .role(Role.SHIPWRIGHT.name())
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .build();
    public static final CharacterRecord CHARACTER_BROOK = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000009"))
            .name("Brook")
            .role(Role.MUSICIAN.name())
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .devilFruitCode(StaticDevilFruits.YOMI_YOMI_NO_MI.code())
            .build();
    public static final CharacterRecord CHARACTER_JINBE = CharacterRecord.builder()
            .id(UUID.fromString("00000000-0000-0000-0000-000000000010"))
            .name("Jinbe")
            .role(Role.HELMSMAN.name())
            .faction(Faction.PIRATE.name())
            .crewId(CREW_STRAW_HATS.id())
            .build();

    public static final List<CharacterRecord> CHARACTER_ALL = List.of(
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
