package com.nimbus.onepiece.service;

import com.nimbus.onepiece.PersistenceTestData;
import com.nimbus.onepiece.domain.Crew;
import com.nimbus.onepiece.persistence.CrewRepository;
import com.nimbus.onepiece.persistence.records.CrewRecord;
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
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CrewServiceTest {

    @Mock
    CrewRepository crewRepository;
    @InjectMocks
    CrewService objectUnderTest;

    @Test
    @Order(1)
    void getCrew() {
        // given
        CrewRecord record = PersistenceTestData.CREW_STRAW_HATS;
        when(crewRepository.findById(record.id())).thenReturn(Mono.just(record));
        // when
        Crew actual = objectUnderTest.getCrew(record.id()).block();
        // then
        assertNotNull(actual);
        assertEquals(
                Crew.builder()
                        .id(record.id())
                        .name(record.name())
                        .members(List.of())
                        .build(),
                actual);
    }

    @Test
    @Order(2)
    void getCrew_notfound() {
        // given
        UUID unknownCrewId = UUID.randomUUID();
        when(crewRepository.findById(unknownCrewId)).thenReturn(Mono.empty());
        // when
        Crew actual = objectUnderTest.getCrew(unknownCrewId).block();
        // then
        assertNull(actual);
    }

    @Test
    @Order(3)
    void getAllCrews() {
        // given
        when(crewRepository.findAll()).thenReturn(Flux.fromStream(Stream.of(PersistenceTestData.CREW_STRAW_HATS)));
        // when
        Collection<Crew> actual = objectUnderTest.getAllCrews().collectList().block();
        // then
        assertNotNull(actual);
        assertEquals(1, actual.size());
    }
}