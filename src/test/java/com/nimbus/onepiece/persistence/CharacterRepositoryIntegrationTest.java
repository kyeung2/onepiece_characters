package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.domain.Faction;
import com.nimbus.onepiece.domain.Role;
import com.nimbus.onepiece.persistence.records.CharacterRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Testcontainers
class CharacterRepositoryIntegrationTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");

    @Test
    void contextLoads() {
        assertTrue(postgres.isRunning());
    }

    @Test
    void findById() {
        //given
        UUID luffyId = HardCodedValues.CHARACTER_LUFFY.id();
        //when
        Optional<CharacterRecord> actual = characterRepository.findById(luffyId);
        //then
        assertTrue(actual.isPresent());
        CharacterRecord actualCharacter = actual.get();
        assertEquals(luffyId, actualCharacter.id());
        assertEquals("Monkey D. Luffy", actualCharacter.name());
        assertEquals(Role.CAPTAIN.name(), actualCharacter.role());
        assertEquals(Faction.PIRATE.name(), actualCharacter.faction());
        assertNotNull(actualCharacter.crewId());
    }

    @Test
    void findAll() {
        //when
        Collection<CharacterRecord> actual = characterRepository.findAll();
        //then
        assertEquals(10, actual.size());
    }

    @Test
    void findAllByCrewId() {
        //given
        UUID strawHatsId = HardCodedValues.CREW_STRAW_HATS_ID;
        //when
        Collection<CharacterRecord> actual = characterRepository.findAllByCrewId(strawHatsId);
        //then
        assertEquals(10, actual.size());
        assertEquals(10, actual.stream().filter(c -> c.crewId().equals( strawHatsId)).count());
    }
}