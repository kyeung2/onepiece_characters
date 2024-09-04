package com.nimbus.onepiece.persistence.records;

import lombok.Builder;
import lombok.NonNull;

import java.util.UUID;

@Builder
public record CrewRecord(
        @NonNull UUID id,
        @NonNull String name) {
}
