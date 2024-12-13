package kopo.poly.test;

import reactor.core.publisher.Mono;

public class MonoEaxmple {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Helll, Mono!");

        // 구독하여 데이터 출력
        mono.subscribe(System.out::println);

    }

}
