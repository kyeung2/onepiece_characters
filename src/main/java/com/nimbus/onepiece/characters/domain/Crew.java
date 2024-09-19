package com.nimbus.onepiece.characters.domain;

import lombok.Builder;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Builder
public record Crew(
        @NonNull UUID id,
        @NonNull String name,
        @NonNull List<Character> members) {
}
