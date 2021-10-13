package com.smarttech.reactive.programming.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class FluxAndMonoServices {
    public Flux<String> fruitFlux() {
        return Flux.fromIterable(List.of("Apple", "Mongo", "Banana", "Orange"));
    }

    public Mono<String> fruitMono() {
        return  Mono.just("Apple");
    }

    public Flux<String> fruitFluxFlatMap() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .flatMap(s -> Flux.just(s.split("")));
                //.log();
    }

    public Flux<String> flatMapAsync() {
        return  Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .flatMap(s -> Flux.fromIterable(List.of(s.split(""))))
                .delayElements(Duration.ofMillis(new Random().nextInt(1000)))
                .log();
    }

    public Flux<String> fruitsFluxConcatMap() {
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .concatMap(s -> Flux.fromIterable(List.of(s.split(""))));
                //.delayElements(Duration.ofMillis(new Random().nextInt(1000)));
                //.log();
    }

    public Flux<String> fruitMonoFlatMapMany() {
        return  Mono.just("Orange")
                .flatMapMany(s -> Flux.just(s.split("")))
                .log();
    }

    public  Flux<String> fruitFluxTransform(int number) {

        Function<Flux<String>, Flux<String>> transformData = data -> data.filter(s-> s.length() > 5);
        return  Flux.fromIterable(List.of("Orange", "Apple", "Banana"))
                .transform(transformData);
                //.filter(s -> s.length() > number);
    }


    public  Flux<String> fruitFluxTransformDefaultIfEmpty(int number) {

        Function<Flux<String>, Flux<String>> transformData = data -> data.filter(s-> s.length() > number);
        return  Flux.fromIterable(List.of("Orange", "Apple", "Banana"))
                .transform(transformData)
                .defaultIfEmpty("No data found");
        //.filter(s -> s.length() > number);
    }

    public  Flux<String> fruitFluxTransformSwitchIfEmpty(int number) {

        Function<Flux<String>, Flux<String>> transformData = data -> data.filter(s-> s.length() > number);
        return  Flux.fromIterable(List.of("Orange", "Apple", "Banana"))
                .transform(transformData)
                .switchIfEmpty(Flux.just("PineApple"));
        //.filter(s -> s.length() > number);
    }

    public Flux<String> fruitFluxConcat() {
            Flux<String> fruits = Flux.just("Apple", "Mango", "Orange");
            Flux<String> veggies = Flux.just("Tomato", "Lemon");

            return Flux.concat(fruits, veggies);
    }

    public static void main(String[] args) {

        FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();
        /*
        System.out.printf("Flux example :: ");
        Flux<String> fluxOfString = fluxAndMonoServices.fruitFlux().log();
        fluxOfString.subscribe(s-> {
            System.out.println(s);
        });

        System.out.printf("Mono example :: ");

        fluxAndMonoServices.fruitMono().subscribe(System.out::println);

        fluxAndMonoServices.fruitFluxFlatMap().subscribe(System.out::println);
        */

        //fluxAndMonoServices.flatMapAsync().subscribe(s -> System.out.println(s));

        // ************************************************************

        //fluxAndMonoServices.fruitsFluxConcatMap().subscribe(System.out::println);

        //fluxAndMonoServices.fruitMonoFlatMapMany().subscribe(System.out::println);

        //fluxAndMonoServices.fruitFluxTransform(5).subscribe(item -> System.out.println(item));

        //fluxAndMonoServices.fruitFluxTransformDefaultIfEmpty(15).subscribe(s -> System.out.println(s));
        fluxAndMonoServices.fruitFluxTransformSwitchIfEmpty(15).subscribe(System.out::println);
        fluxAndMonoServices.fruitFluxConcat().subscribe(System.out::println);
    }
}
