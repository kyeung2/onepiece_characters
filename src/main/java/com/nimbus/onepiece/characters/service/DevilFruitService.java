package com.nimbus.onepiece.characters.service;

import com.nimbus.onepiece.devilfruits.interfaces.dto.DevilFruitDto;
import com.nimbus.onepiece.devilfruits.sdk.client.DevilFruitsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DevilFruitService {

    private final DevilFruitsClient client;

    public Mono<DevilFruitDto> getDevilFruit(String code) {
        if (code == null) {
            return Mono.empty();
        }
        return client.getDevilFruit(code);
    }
}
