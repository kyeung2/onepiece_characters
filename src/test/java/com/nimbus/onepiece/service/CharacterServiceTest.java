package com.nimbus.onepiece.service;

import com.nimbus.onepiece.TestData;
import com.nimbus.onepiece.domain.Character;
import com.nimbus.onepiece.domain.Faction;
import com.nimbus.onepiece.domain.Role;
import com.nimbus.onepiece.persistence.CharacterRepository;
import com.nimbus.onepiece.persistence.records.CharacterRecord;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CharacterServiceTest {

    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    CharacterService objectUnderTest;

    @Test
    @Order(1)
    void getCharacter() {
        // given
        CharacterRecord record = TestData.CHARACTER_LUFFY;
        UUID luffyId = record.id();
        when(characterRepository.findById(luffyId)).thenReturn(Optional.of(record));
        // when
        Optional<Character> actual = objectUnderTest.getCharacter(luffyId);
        // then
        assertTrue(actual.isPresent());
        assertEquals(
                Character.builder()
                        .id(record.id())
                        .name(record.name())
                        .role(Role.valueOf(record.role()))
                        .faction(Faction.valueOf(record.faction()))
                        .crewId(record.crewId())
                        .build(),
                actual.get());
    }

    @Test
    @Order(2)
    void getCharacter_notfound() {
        // given
        UUID unknownId = UUID.randomUUID();
        when(characterRepository.findById(unknownId)).thenReturn(Optional.empty());
        // when
        Optional<Character> actual = objectUnderTest.getCharacter(unknownId);
        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    @Order(3)
    void getCharacters() {
        // given
        UUID crewId = TestData.CREW_STRAW_HATS.id();
        when(characterRepository.findAllByCrewId(crewId)).thenReturn(TestData.CHARACTER_ALL);
        // when
        Collection<Character> actual = objectUnderTest.getCharacters(crewId);
        // then
        assertEquals(10, actual.size());
    }

    @Test
    @Order(4)
    void getCharacters_notfound() {
        // given
        UUID unknownCrewId = UUID.randomUUID();
        when(characterRepository.findAllByCrewId(unknownCrewId)).thenReturn(List.of());
        // when
        Collection<Character> actual = objectUnderTest.getCharacters(unknownCrewId);
        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    @Order(5)
    void getAllCharacters() {
        // given
        when(characterRepository.findAll()).thenReturn(TestData.CHARACTER_ALL);
        // when
        Collection<Character> actual = objectUnderTest.getAllCharacters();
        // then
        assertEquals(10, actual.size());
    }

}