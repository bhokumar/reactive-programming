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
}
