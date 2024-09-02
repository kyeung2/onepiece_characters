package com.nimbus.onepiece.service;

import com.nimbus.onepiece.model.Crew;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CrewService {

    public static final UUID STRAW_HATS_CREW_ID = UUID.fromString("00000000-0000-0000-0001-000000000000");

    //TODO this would be an entry in the CREW table with no reference to the CHARACTER table
    private static final Crew STRAW_HATS = Crew.builder()
            .id(STRAW_HATS_CREW_ID)
            .name("Straw Hat Pirates")
            .members(List.of())
            .build();

    public Optional<Crew> getCrewById(UUID id) {
        return STRAW_HATS_CREW_ID.equals(id) ? Optional.of(STRAW_HATS) : Optional.empty();
    }

    public Collection<Crew> getAllCrews() {
        return List.of(STRAW_HATS);
    }
}

