package com.nimbus.onepiece.persistence.records;

import lombok.Builder;
import lombok.NonNull;

import java.util.UUID;

@Builder
public record CharacterRecord(
        @NonNull UUID id,
        @NonNull String name,
        @NonNull String role,
        @NonNull String faction,
        UUID crewId,
        UUID devilFruitId) {
}
