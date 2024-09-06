package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.TestData;
import com.nimbus.onepiece.domain.Faction;
import com.nimbus.onepiece.domain.Role;
import com.nimbus.onepiece.persistence.records.CharacterRecord;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CharacterRepositoryIntegrationTest {

    @Autowired
    CharacterRepository objectUnderTest;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest");

    @Test
    @Order(1)
    void contextLoads() {
        assertTrue(postgres.isRunning());
    }

    @Test
    @Order(2)
    void findById() {
        //given
        UUID luffyId = TestData.CHARACTER_LUFFY.id();
        //when
        Optional<CharacterRecord> actual = objectUnderTest.findById(luffyId);
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
    @Order(3)
    void findAll() {
        //when
        Collection<CharacterRecord> actual = objectUnderTest.findAll();
        //then
        assertEquals(10, actual.size());
    }

    @Test
    @Order(4)
    void findAllByCrewId() {
        //given
        UUID strawHatsId = TestData.CREW_STRAW_HATS_ID;
        //when
        Collection<CharacterRecord> actual = objectUnderTest.findAllByCrewId(strawHatsId);
        //then
        assertEquals(10, actual.size());
        assertEquals(10, actual.stream().filter(c -> c.crewId().equals(strawHatsId)).count());
    }
}