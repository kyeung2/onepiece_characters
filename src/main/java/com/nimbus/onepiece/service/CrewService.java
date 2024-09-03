package com.nimbus.onepiece.service;

import com.nimbus.onepiece.domain.Crew;
import com.nimbus.onepiece.persistence.CrewRepository;
import com.nimbus.onepiece.persistence.records.CrewRecord;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CrewService {

    private final CrewRepository crewRepository;

    public Optional<Crew> getCrew(@NonNull UUID id) {
        return crewRepository.findById(id)
                .map(CrewService::toDomain);
    }

    public Collection<Crew> getAllCrews() {
        return crewRepository.findAll()
                .stream()
                .map(CrewService::toDomain)
                .toList();
    }

    private static Crew toDomain(CrewRecord record) {
        return Crew.builder()
                .id(record.id())
                .name(record.name())
                .members(List.of())
                .build();
    }
}

