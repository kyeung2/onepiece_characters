package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.persistence.records.CharacterRecord;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class CharacterRepository {

    public Optional<CharacterRecord> findById(@NonNull UUID id) {

        //TODO finish this later
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("id", id);

//        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM CHARACTERS WHERE id = :id", params, characterRecordRowMapper()));

        return Optional.empty();
    }

    public Collection<CharacterRecord> findAll() {
        //return jdbcTemplate.query("SELECT * FROM CHARACTERS", characterRecordRowMapper());
        return List.of();
    }

    public Collection<CharacterRecord> findAllByCrewId(@NonNull UUID crewId) {

//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("crew_id", crewId);

        //   return jdbcTemplate.query("SELECT * FROM CHARACTERS WHERE crew_id = :crew_id", params, characterRecordRowMapper());
        return List.of();
    }

//    private static RowMapper<CharacterRecord> characterRecordRowMapper() {
//        return (rs, _) ->
//                CharacterRecord.builder()
//                        .id(UUID.fromString(rs.getString("id")))
//                        .name(rs.getString("name"))
//                        .role(rs.getString("role"))
//                        .faction(rs.getString("faction"))
//                        .crewId(Optional.ofNullable(rs.getString("crew_id")).map(UUID::fromString).orElse(null))
//                        .build();
//    }
}
