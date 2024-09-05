package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.persistence.records.CrewRecord;
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
public class CrewRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public Optional<CrewRecord> findById(@NonNull UUID id) {

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM CREW WHERE id = :id", params, (rs, _) ->
                CrewRecord.builder()
                        .id(UUID.fromString(rs.getString("id")))
                        .name(rs.getString("name"))
                        .build()));
    }

    public Collection<CrewRecord> findAll() {
        return jdbcTemplate.query("SELECT * FROM CREW", (rs, _) ->
                CrewRecord.builder()
                        .id(UUID.fromString(rs.getString("id")))
                        .name(rs.getString("name"))
                        .build());
    }
}
