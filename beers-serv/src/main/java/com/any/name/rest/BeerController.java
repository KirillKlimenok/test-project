package com.any.name.rest;

import com.any.name.model.Beer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Configuration
@RestController
public interface BeerController {

    @GetMapping("/beers")
    Mono<ResponseEntity<Flux<Beer>>> getList();

    @PostMapping
    ResponseEntity<Mono<Beer>> save(@RequestBody Beer beer);
}
