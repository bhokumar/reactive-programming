package com.smarttech.reactive.programming;

import com.smarttech.reactive.programming.services.FluxAndMonoServices;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxMonoServiceTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void fruitFluxConcat() {
        var fruitFlux = fluxAndMonoServices.fruitFluxConcat();
        StepVerifier.create(fruitFlux)
                .expectNext("Apple", "Mango", "Orange", "Tomato", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitFluxConcatWith() {
        var fruitFlux = fluxAndMonoServices.fruitFluxConcatWith();
        StepVerifier.create(fruitFlux)
                .expectNext("Apple", "Mango", "Orange", "Tomato", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitMonoConcatWith() {
        var fruitFlux = fluxAndMonoServices.fruitMonoConcatWith();
        StepVerifier.create(fruitFlux)
                .expectNext("Apple","Tomato")
                .verifyComplete();
    }

    @Test
    void fruitFluxMerge() {
        var fruitFlux = fluxAndMonoServices.fruitFluxMerge();
        StepVerifier.create(fruitFlux)
                .expectNext("Apple", "Tomato", "Mango", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitFluxMergeWith() {
        var fruitFlux = fluxAndMonoServices.fruitFluxMergeWith();
        StepVerifier.create(fruitFlux)
                .expectNext("Apple", "Tomato", "Mango", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitFluxMergeSequential() {
        var fruitFlux = fluxAndMonoServices.fruitFluxMergeSequential();
        StepVerifier.create(fruitFlux)
                .expectNext("Apple", "Mango", "Orange", "Tomato", "Lemon")
                .verifyComplete();
    }

    @Test
    void fruitFluxZip() {
        var fruitFlux = fluxAndMonoServices.fruitsFluxZip();
        StepVerifier.create(fruitFlux)
                .expectNext("AppleTomato", "MangoLemon")
                .verifyComplete();
    }

    @Test
    void fruitFluxZipExtra() {
        var fruitFlux = fluxAndMonoServices.fruitsFluxZipExtra();
        StepVerifier.create(fruitFlux)
                .expectNext("AppleTomato", "MangoLemon")
                .verifyComplete();
    }

    @Test
    void fruitFluxZipWith() {
        var fruitFlux = fluxAndMonoServices.fruitsFluxZipWith();
        StepVerifier.create(fruitFlux)
                .expectNext("AppleTomato", "MangoLemon")
                .verifyComplete();
    }

    @Test
    void fruitFluxZipWithTuple() {
        var fruitFlux = fluxAndMonoServices.fruitsFluxTuple();
        StepVerifier.create(fruitFlux)
                .expectNext("AppleTomatoPotato", "MangoLemonBeans")
                .verifyComplete();
    }

    @Test
    void fruitMonoZip() {
        var fruitFlux = fluxAndMonoServices.fruitsMonoZip();
        StepVerifier.create(fruitFlux)
                .expectNext("AppleTomato")
                .verifyComplete();
    }

    @Test
    void fruitsMonoZipWith() {
        var fruitFlux = fluxAndMonoServices.fruitsMonoZipWith();
        StepVerifier.create(fruitFlux)
                .expectNext("AppleTomato")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnReturn() {
        var fruitFlux = fluxAndMonoServices.fruitsFluxOnReturn();
        StepVerifier.create(fruitFlux)
                .expectNext("Mango", "Apple", "Default value")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnContinue() {
        var fruitFlux = fluxAndMonoServices.fruitsFluxOnReturn();
        StepVerifier.create(fruitFlux)
                .expectNext("Mango", "Apple", "Default value")
                .verifyComplete();
    }

}
