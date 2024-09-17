package com.nimbus.onepiece.service.devilfruit;

import com.nimbus.onepiece.domain.devilfruit.DevilFruit;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.nimbus.onepiece.domain.devilfruit.StaticDevilFruits.ALL_DEVIL_FRUITS;

/**
 * TODO It would be interesting to create a DevilFruit microservice which has a RESTful API and that contributes
 * to this subgraph.
 */
@Service
public class DevilFruitService {

    public Mono<DevilFruit> getDevilFruit(UUID id) {
        if (id == null) {
            return Mono.empty();
        }

        return ALL_DEVIL_FRUITS.stream()
                .filter(df -> df.id().equals(id))
                .findFirst()
                .map(Mono::just)
                .orElse(Mono.empty());
    }
}
