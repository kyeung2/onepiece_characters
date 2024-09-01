package com.nimbus.onepiece.model;

import lombok.Builder;
import lombok.NonNull;

import java.util.UUID;

@Builder
public record Character(
        @NonNull UUID id,
        @NonNull String name,
        @NonNull Role role,
        @NonNull Faction faction
        //TODO give a character a Crew, a cyclic dependency and figure out how that works

) {
}
