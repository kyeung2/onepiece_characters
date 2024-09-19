package com.nimbus.onepiece.characters.service;

import com.nimbus.onepiece.characters.domain.Crew;
import com.nimbus.onepiece.characters.persistence.CrewRepository;
import com.nimbus.onepiece.characters.persistence.records.CrewRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CrewService {

    private final CrewRepository crewRepository;

    public Mono<Crew> getCrew(UUID id) {
        if (id == null) {
            return Mono.empty();
        }

        return crewRepository.findById(id)
                .map(CrewService::toDomain);
    }

    public Flux<Crew> getAllCrews() {
        return crewRepository.findAll()
                .map(CrewService::toDomain);
    }

    private static Crew toDomain(CrewRecord record) {
        return Crew.builder()
                .id(record.id())
                .name(record.name())
                .members(List.of())
                .build();
    }
}

