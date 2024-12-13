package kopo.poly.test;

import reactor.core.publisher.Flux;

public class FluxExample {

    public static void main(String[] args) {
        Flux<String> flux = Flux.just("A","B","C");

        flux.subscribe(System.out::println);
    }

}
