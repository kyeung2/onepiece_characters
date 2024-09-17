package com.nimbus.onepiece.service;

import com.nimbus.onepiece.PersistenceTestData;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
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
        CharacterRecord record = PersistenceTestData.CHARACTER_LUFFY;
        UUID luffyId = record.id();
        when(characterRepository.findById(luffyId)).thenReturn(Mono.just(record));
        // when
        Character actual = objectUnderTest.getCharacter(luffyId).block();
        // then
        assertNotNull(actual);
        assertEquals(
                Character.builder()
                        .id(record.id())
                        .name(record.name())
                        .role(Role.valueOf(record.role()))
                        .faction(Faction.valueOf(record.faction()))
                        .crewId(record.crewId())
                        .devilFruitId(record.devilFruitId())
                        .build(),
                actual);
    }

    @Test
    @Order(2)
    void getCharacter_notfound() {
        // given
        UUID unknownId = UUID.randomUUID();
        when(characterRepository.findById(unknownId)).thenReturn(Mono.empty());
        // when
        Character actual = objectUnderTest.getCharacter(unknownId).block();
        // then
        assertNull(actual);
    }

    @Test
    @Order(3)
    void getCharacters() {
        // given
        UUID crewId = PersistenceTestData.CREW_STRAW_HATS.id();
        when(characterRepository.findAllByCrewId(crewId)).thenReturn(Flux.fromIterable(PersistenceTestData.CHARACTER_ALL));
        // when
        Collection<Character> actual = objectUnderTest.getCharacters(crewId).collectList().block();
        // then
        assertNotNull(actual);
        assertEquals(10, actual.size());
    }

    @Test
    @Order(4)
    void getCharacters_notfound() {
        // given
        UUID unknownCrewId = UUID.randomUUID();
        when(characterRepository.findAllByCrewId(unknownCrewId)).thenReturn(Flux.empty());
        // when
        Collection<Character> actual = objectUnderTest.getCharacters(unknownCrewId).collectList().block();
        // then
        assertNotNull(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @Order(5)
    void getAllCharacters() {
        // given
        when(characterRepository.findAll()).thenReturn(Flux.fromIterable(PersistenceTestData.CHARACTER_ALL));
        // when
        Collection<Character> actual = objectUnderTest.getAllCharacters().collectList().block();
        // then
        assertNotNull(actual);
        assertEquals(10, actual.size());
    }

}