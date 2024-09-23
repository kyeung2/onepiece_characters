package com.nimbus.onepiece.characters.service;

import com.nimbus.onepiece.devilfruits.interfaces.dto.DevilFruitDto;
import com.nimbus.onepiece.devilfruits.interfaces.dto.StrawHatDevilFruits;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


/**
 * TODO It would be interesting to create a DevilFruit microservice which has a RESTful API and that contributes
 * to this subgraph.
 */
@Service
public class DevilFruitService {

    public Mono<DevilFruitDto> getDevilFruit(String code) {
        if (code == null) {
            return Mono.empty();
        }

        return StrawHatDevilFruits.ALL_STRAW_HATS.stream()
                .filter(df -> df.code().equals(code))
                .findFirst()
                .map(Mono::just)
                .orElse(Mono.empty());
    }
}
