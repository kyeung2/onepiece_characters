package com.nimbus.onepiece.model;

import lombok.Builder;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Builder
public record Crew(
        @NonNull UUID id,
        @NonNull String name,
        Character captain,
        @NonNull List<Character> members) {
}
