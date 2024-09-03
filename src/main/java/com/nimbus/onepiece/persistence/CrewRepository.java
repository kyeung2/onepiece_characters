package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.persistence.records.CrewRecord;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.nimbus.onepiece.persistence.records.HardCodedValues.CREW_STRAW_HATS;
import static com.nimbus.onepiece.persistence.records.HardCodedValues.CREW_STRAW_HATS_ID;

@Repository
@RequiredArgsConstructor
public class CrewRepository {

    //TODO
    // private final NamedParameterJdbcTemplate jdbcTemplate;

    public Optional<CrewRecord> findById(@NonNull UUID id) {
        return CREW_STRAW_HATS_ID.equals(id) ? Optional.of(CREW_STRAW_HATS) : Optional.empty();
    }

    public Collection<CrewRecord> findAll() {
        return List.of(CREW_STRAW_HATS);
    }

}
