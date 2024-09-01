package com.nimbus.onepiece.model;

import lombok.Builder;
import lombok.NonNull;

import java.util.List;

@Builder
public record Crew(
        @NonNull String name,
        @NonNull Character captain,
        @NonNull List<Character> members) {
}
