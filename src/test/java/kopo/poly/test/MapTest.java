package kopo.poly.test;

import reactor.core.publisher.Mono;

public class MapTest {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello, WebFlux")
                .map(data -> data.toUpperCase())
                .map(data -> "exchage data :" + data);

        mono.subscribe(System.out::println);
    }

}
