package com.nimbus.onepiece.characters.persistence;

import com.nimbus.onepiece.characters.persistence.records.CharacterRecord;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.function.BiFunction;

import static java.util.Objects.requireNonNull;


@Repository
@RequiredArgsConstructor
public class CharacterRepository {

    private final DatabaseClient databaseClient;

    public Mono<CharacterRecord> findById(@NonNull UUID id) {
        return databaseClient.sql("SELECT * FROM CHARACTERS WHERE id = :id")
                .bind("id", id)
                .map(rowMapper())
                .one();
    }

    public Flux<CharacterRecord> findAllByCrewId(@NonNull UUID crewId) {
        return databaseClient.sql("SELECT * FROM CHARACTERS WHERE crew_id = :crew_id")
                .bind("crew_id", crewId)
                .map(rowMapper())
                .all();
    }

    public Flux<CharacterRecord> findAll() {
        return databaseClient.sql("SELECT * FROM CHARACTERS")
                .map(rowMapper())
                .all();
    }

    private static BiFunction<Row, RowMetadata, CharacterRecord> rowMapper() {
        return (row, _) ->
                CharacterRecord.builder()
                        .id(requireNonNull(row.get("id", UUID.class)))
                        .name(requireNonNull(row.get("name", String.class)))
                        .role(requireNonNull(row.get("role", String.class)))
                        .faction(requireNonNull(row.get("faction", String.class)))
                        .crewId(row.get("crew_id", UUID.class))
                        .devilFruitCode(row.get("devil_fruit_code", String.class))
                        .build();
    }
}
