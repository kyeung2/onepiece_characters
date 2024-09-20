package com.nimbus.onepiece.characters.service.devilfruit;

import nimbus.onepiece.devilfruits.interfaces.DevilFruit;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static nimbus.onepiece.devilfruits.interfaces.StaticDevilFruits.ALL_DEVIL_FRUITS;


/**
 * TODO It would be interesting to create a DevilFruit microservice which has a RESTful API and that contributes
 * to this subgraph.
 */
@Service
public class DevilFruitService {

    public Mono<DevilFruit> getDevilFruit(String code) {
        if (code == null) {
            return Mono.empty();
        }

        return ALL_DEVIL_FRUITS.stream()
                .filter(df -> df.code().equals(code))
                .findFirst()
                .map(Mono::just)
                .orElse(Mono.empty());
    }
}
