package com.nimbus.onepiece.characters.persistence;

import com.nimbus.onepiece.PersistenceTestData;
import com.nimbus.onepiece.characters.persistence.records.CrewRecord;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Collection;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("integration")
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CrewRepositoryIntegrationTest {

    @Autowired
    CrewRepository objectUnderTest;

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
        UUID expectedId = PersistenceTestData.CREW_STRAW_HATS.id();
        //when
        CrewRecord actual = objectUnderTest.findById(expectedId).block();
        //then
        assertNotNull(actual);
        assertEquals(expectedId, actual.id());
        assertEquals("Straw Hat Pirates", actual.name());
    }

    @Test
    @Order(3)
    void findAll() {
        //when
        Collection<CrewRecord> actual = objectUnderTest.findAll().collectList().block();
        //then
        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertEquals("Straw Hat Pirates", actual.iterator().next().name());
    }
}
