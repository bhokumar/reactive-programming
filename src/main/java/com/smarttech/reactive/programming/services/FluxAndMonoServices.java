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

    public Flux<String> fruitFluxConcatWith() {
        Flux<String> fruits = Flux.just("Apple", "Mango", "Orange");
        Flux<String> veggies = Flux.just("Tomato", "Lemon");

        return fruits.concatWith(veggies);
    }

    public Flux<String> fruitMonoConcatWith() {
        Mono<String> fruits = Mono.just("Apple");
        Mono<String> veggies = Mono.just("Tomato");

        return fruits.concatWith(veggies);
    }

    public Flux<String> fruitFluxMerge() {
        Flux<String> fruits = Flux.just("Apple", "Mango").delayElements(Duration.ofMillis(50));
        Flux<String> veggies = Flux.just("Tomato", "Lemon").delayElements(Duration.ofMillis(75));

        return Flux.merge(fruits, veggies);
    }

    public Flux<String> fruitFluxMergeWith() {
        Flux<String> fruits = Flux.just("Apple", "Mango").delayElements(Duration.ofMillis(50));
        Flux<String> veggies = Flux.just("Tomato", "Lemon").delayElements(Duration.ofMillis(75));

        return fruits.mergeWith(veggies);
    }

    public Flux<String> fruitFluxMergeSequential() {
        Flux<String> fruits = Flux.just("Apple", "Mango", "Orange").delayElements(Duration.ofMillis(50));
        Flux<String> veggies = Flux.just("Tomato", "Lemon").delayElements(Duration.ofMillis(75));

        return Flux.mergeSequential(fruits, veggies);
    }

    public Flux<String> fruitsFluxZip() {
        Flux<String> fruits = Flux.just("Apple", "Mango");
        Flux<String> veggies = Flux.just("Tomato", "Lemon");

        return Flux.zip(fruits, veggies, (p1, p2) -> p1 + p2);
    }

    public Mono<String> fruitsMonoZip() {
        Mono<String> fruits = Mono.just("Apple");
        Mono<String> veggies = Mono.just("Tomato");

        return Mono.zip(fruits, veggies, (p1, p2) -> p1 + p2);
    }

    public Mono<String> fruitsMonoZipWith() {
        Mono<String> fruits = Mono.just("Apple");
        Mono<String> veggies = Mono.just("Tomato");

        return fruits.zipWith(veggies, (p1, p2) -> p1 + p2);
    }

    public Flux<String> fruitsFluxZipExtra() {
        Flux<String> fruits = Flux.just("Apple", "Mango", "Orange");
        Flux<String> veggies = Flux.just("Tomato", "Lemon");

        return Flux.zip(fruits, veggies, (p1, p2) -> p1 + p2);
    }

    public Flux<String> fruitsFluxZipWith() {
        Flux<String> fruits = Flux.just("Apple", "Mango");
        Flux<String> veggies = Flux.just("Tomato", "Lemon");

        return fruits.zipWith(veggies, (s1, s2) -> s1 + s2);
    }

    public Flux<String> fruitsFluxTuple() {
        Flux<String> fruits = Flux.just("Apple", "Mango");
        Flux<String> veggies = Flux.just("Tomato", "Lemon");
        Flux<String> beans = Flux.just("Potato", "Beans");

        return Flux.zip(fruits,veggies, beans)
                .map(objects -> objects.getT1() + objects.getT2() + objects.getT3());
    }

    public Flux<String> fruitsFluxFilterDoOn(int number) {
        return Flux.just("Mango", "Orange", "Banana")
                .filter(s-> s.length() > number)
                .doOnNext(s -> System.out.println("s=" + s));
    }

    public Flux<String> fruitsFluxOnReturn() {
        return Flux.just("Mango", "Apple")
                .concatWith(Flux.error(new RuntimeException("Error occurred!")))
                .onErrorReturn("Default value");
    }

    public Flux<String> fruitsFluxOnContinue() {
        return Flux.just("Mango", "Apple", "Orange")
                .map(s -> {
                    if (s.equals("Apple")) {
                        throw  new RuntimeException("Exception occurred!");
                    }else {
                        return s;
                    }
                })
                .onErrorContinue((e, item) -> {
                    System.out.println("e = " + e);
                    System.out.println("item = " + item);
                });
    }
}
