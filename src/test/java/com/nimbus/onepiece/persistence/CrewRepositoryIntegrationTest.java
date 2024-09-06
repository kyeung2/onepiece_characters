package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.persistence.records.CrewRecord;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
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
        var expectedId = UUID.fromString("00000000-0000-0000-0001-000000000000");
        //when
        Optional<CrewRecord> actual = objectUnderTest.findById(expectedId);
        //then
        assertTrue(actual.isPresent());
        assertEquals(expectedId, actual.get().id());
        assertEquals("Straw Hat Pirates", actual.get().name());
    }

    @Test
    @Order(3)
    void findAll() {
        //when
        Collection<CrewRecord> actual = objectUnderTest.findAll();
        //then
        assertEquals(1, actual.size());
        assertEquals("Straw Hat Pirates", actual.iterator().next().name());
    }
}