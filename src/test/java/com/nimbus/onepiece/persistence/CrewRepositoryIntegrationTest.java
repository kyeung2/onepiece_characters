package com.nimbus.onepiece.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest
@Testcontainers
class CrewRepositoryIntegrationTest {

    @Autowired
    private CrewRepository crewRepository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("peak_fiction_db")
            .withUsername("oda")
            .withPassword("god_tier");

    @Test
    void contextLoads() {
        Assertions.assertTrue(postgres.isRunning());
    }

    @Test
    void findById() {

        //TODO before going further exploring test containers I need to use the DB
        // I will use R2DBC instead of JDBC
    }

    @Test
    void findAll() {
    }
}