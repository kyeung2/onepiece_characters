package com.nimbus.onepiece.service;

import com.nimbus.onepiece.TestData;
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

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        CrewRecord record = TestData.CREW_STRAW_HATS;
        when(crewRepository.findById(record.id())).thenReturn(Optional.of(record));
        // when
        Optional<Crew> actual = objectUnderTest.getCrew(record.id());
        // then
        assertTrue(actual.isPresent());
        assertEquals(
                Crew.builder()
                        .id(record.id())
                        .name(record.name())
                        .members(List.of())
                        .build(),
                actual.get());
    }

    @Test
    @Order(2)
    void getCrew_notfound() {
        // given
        UUID unknownCrewId = UUID.randomUUID();
        when(crewRepository.findById(unknownCrewId)).thenReturn(Optional.empty());
        // when
        Optional<Crew> actual = objectUnderTest.getCrew(unknownCrewId);
        // then
        assertTrue(actual.isEmpty());
    }

    @Test
    @Order(3)
    void getAllCrews() {
        // given
        when(crewRepository.findAll()).thenReturn(List.of(TestData.CREW_STRAW_HATS));
        // when
        Collection<Crew> actual = objectUnderTest.getAllCrews();
        // then
        assertEquals(1, actual.size());
    }
}