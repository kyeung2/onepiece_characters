package com.nimbus.onepiece.persistence;

import com.nimbus.onepiece.persistence.records.CrewRecord;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiFunction;

import static java.util.Objects.*;


@Repository
@RequiredArgsConstructor
public class CrewRepository {

    private final DatabaseClient databaseClient;

    public Mono<CrewRecord> findById(@NonNull UUID id) {
        return databaseClient.sql("SELECT * FROM CREW WHERE id = :id")
                .bind("id", id)
                .map(rowMapper())
                .one();
    }

    public Flux<CrewRecord> findAll() {
        return databaseClient.sql("SELECT * FROM CREW")
                .map(rowMapper())
                .all();
    }

    private static BiFunction<Row, RowMetadata, CrewRecord> rowMapper() {
        return (row, _) ->
                CrewRecord.builder()
                        .id(requireNonNull(row.get("id", UUID.class)))
                        .name(requireNonNull(row.get("name", String.class)))
                        .build();
    }
}
