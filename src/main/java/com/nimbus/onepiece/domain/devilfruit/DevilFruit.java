package com.nimbus.onepiece.domain.devilfruit;

import lombok.Builder;
import lombok.NonNull;

import java.util.UUID;

/**
 * TODO this belongs in a separate microservice
 */
@Builder
public record DevilFruit(
        @NonNull UUID id,
        @NonNull String name,
        @NonNull DevilFruitType type,
        @NonNull String ability){
}
