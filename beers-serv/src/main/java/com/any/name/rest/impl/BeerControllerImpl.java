package com.any.name.rest.impl;

import com.any.name.model.Beer;
import com.any.name.rest.BeerController;
import com.any.name.service.BeerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BeerControllerImpl implements BeerController {
    private final BeerService beerService;


    @Override
    public Mono<ResponseEntity<Flux<Beer>>> getList() {
        return Mono
                .just(ResponseEntity
                        .ok()
                        .body(beerService.list())
                );
    }

    @Override
    public ResponseEntity<Mono<Beer>> save(Beer beer) {
        return ResponseEntity
                .ok()
                .body(beerService.save(beer));
    }
}
