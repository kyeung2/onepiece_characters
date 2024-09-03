package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.domain.Role;
import com.nimbus.onepiece.persistence.records.CharacterRecord;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static com.nimbus.onepiece.persistence.records.HardCodedValues.CHARACTER_ALL;

@Repository
public class CharacterRepository {


    public Optional<CharacterRecord> findCharacterById(@NonNull UUID id) {
        return CHARACTER_ALL.stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
    }

    public Collection<CharacterRecord> findAll() {
        return CHARACTER_ALL;
    }

    public Collection<CharacterRecord> findAllByCrewId(@NonNull UUID crewId) {
        return CHARACTER_ALL.stream()
                .filter(c -> c.crewId() != null)
                .filter(c -> c.crewId().equals(crewId))
                .toList();
    }

    public Collection<CharacterRecord> findAllByCrewIdAndRole(@NonNull UUID crewId, @NonNull Role role) {
        return CHARACTER_ALL.stream()
                .filter(c -> c.crewId() != null)
                .filter(c -> c.crewId().equals(crewId))
                .filter(c -> c.role().equals(role.name()))
                .toList();
    }
}
