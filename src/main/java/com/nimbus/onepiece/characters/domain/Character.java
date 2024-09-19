package com.nimbus.onepiece.characters.domain;

import lombok.Builder;
import lombok.NonNull;

import java.util.UUID;

@Builder
public record Character(
        @NonNull UUID id,
        @NonNull String name,
        @NonNull Role role,
        @NonNull Faction faction,
        UUID crewId,
        UUID devilFruitId) {
}
