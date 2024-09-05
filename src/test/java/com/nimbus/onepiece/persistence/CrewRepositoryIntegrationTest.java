package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.persistence.records.CrewRecord;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@Testcontainers
class CrewRepositoryIntegrationTest {

    @Autowired
    private CrewRepository crewRepository;

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
        var expectedId = UUID.fromString("00000000-0000-0000-0001-000000000000");
        //when
        Optional<CrewRecord> actual = crewRepository.findById(expectedId);
        //then
        assertTrue(actual.isPresent());
        assertEquals(expectedId, actual.get().id());
        assertEquals("Straw Hat Pirates", actual.get().name());
    }

    @Test
    void findAll() {
        //when
        Collection<CrewRecord> actual = crewRepository.findAll();
        //then
        assertEquals(1, actual.size());
        assertEquals("Straw Hat Pirates", actual.iterator().next().name());
    }
}