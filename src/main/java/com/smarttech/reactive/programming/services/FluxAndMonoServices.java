package com.smarttech.reactive.programming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoServices {
    public Flux<String> fruitFlux() {
        return Flux.fromIterable(List.of("Apple", "Mongo", "Banana", "Orange"));
    }

    public Mono<String> fruitMono() {
        return  Mono.just("Apple");
    }

    public Flux<String> fruitFluxMap() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .flatMap(s -> Flux.just(s.split("")))
                .log();
    }

    public static void main(String[] args) {
        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
        System.out.printf("Flux example :: ");
        Flux<String> fluxOfString = fluxAndMonoServices.fruitFlux().log();
        fluxOfString.subscribe(s-> {
            System.out.println(s);
        });

        System.out.printf("Mono example :: ");

        fluxAndMonoServices.fruitMono().subscribe(System.out::println);
    }
}
