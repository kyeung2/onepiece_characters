package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.persistence.records.CharacterRecord;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;


@Repository
@RequiredArgsConstructor
public class CharacterRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public Optional<CharacterRecord> findCharacterById(@NonNull UUID id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM CHARACTERS WHERE id = :id", params, (rs, _) ->
                CharacterRecord.builder()
                        .id(UUID.fromString(rs.getString("id")))
                        .name(rs.getString("name"))
                        .role(rs.getString("role"))
                        .faction(rs.getString("faction"))
                        .crewId(Optional.ofNullable(rs.getString("crew_id")).map(UUID::fromString).orElse(null))
                        .build()));
    }

    public Collection<CharacterRecord> findAll() {
        return jdbcTemplate.query("SELECT * FROM CHARACTERS", (rs, _) ->
                CharacterRecord.builder()
                        .id(UUID.fromString(rs.getString("id")))
                        .name(rs.getString("name"))
                        .role(rs.getString("role"))
                        .faction(rs.getString("faction"))
                        .crewId(Optional.ofNullable(rs.getString("crew_id")).map(UUID::fromString).orElse(null))
                        .build());
    }

    public Collection<CharacterRecord> findAllByCrewId(@NonNull UUID crewId) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("crew_id", crewId);

        return jdbcTemplate.query("SELECT * FROM CHARACTERS WHERE crew_id = :crew_id", params, (rs, _) ->
                CharacterRecord.builder()
                        .id(UUID.fromString(rs.getString("id")))
                        .name(rs.getString("name"))
                        .role(rs.getString("role"))
                        .faction(rs.getString("faction"))
                        .crewId(Optional.ofNullable(rs.getString("crew_id")).map(UUID::fromString).orElse(null))
                        .build());
    }
}
