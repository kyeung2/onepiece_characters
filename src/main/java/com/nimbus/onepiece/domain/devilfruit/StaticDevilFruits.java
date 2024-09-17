package com.nimbus.onepiece.domain.devilfruit;

import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.UUID;

/**
 * TODO It would be interesting to create a DevilFruit microservice which has a RESTful API and that contributes
 * to this subgraph.
 */
@UtilityClass
public class StaticDevilFruits {

    public static final DevilFruit GOMU_GOMU_NO_MI = DevilFruit.builder()
            .id(UUID.fromString("00000000-0000-0001-0000-000000000000"))
            .name("Gomu Gomu no Mi")
            .type(DevilFruitType.PARAMECIA)
            .ability("Grants the user's body rubber-like properties")
            // this would be a database entry. How would this ensure integrity?
            .build();

    public static final DevilFruit HITO_HITO_NO_MI = DevilFruit.builder()
            .id(UUID.fromString("00000000-0000-0002-0000-000000000000"))
            .name("Hito Hito no Mi")
            .type(DevilFruitType.ZOAN)
            .ability("Allows the user to transform into a human or human hybrid")
            .build();

    public static final DevilFruit HANA_HANA_NO_MI = DevilFruit.builder()
            .id(UUID.fromString("00000000-0000-0003-0000-000000000000"))
            .name("Hana Hana no Mi")
            .type(DevilFruitType.PARAMECIA)
            .ability("Allows the user to sprout replicas of their body parts on any surface")
            .build();

    public static final DevilFruit YOMI_YOMI_NO_MI = DevilFruit.builder()
            .id(UUID.fromString("00000000-0000-0004-0000-000000000000"))
            .name("Yomi Yomi no Mi")
            .type(DevilFruitType.PARAMECIA)
            .ability("Grants the user resurrection and soul-based abilities")
            .build();

    public static final Set<DevilFruit> ALL_DEVIL_FRUITS = Set.of(
            GOMU_GOMU_NO_MI,
            HITO_HITO_NO_MI,
            HANA_HANA_NO_MI,
            YOMI_YOMI_NO_MI);
}
