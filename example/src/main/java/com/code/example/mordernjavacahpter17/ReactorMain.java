package com.code.example.mordernjavacahpter17;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


@Slf4j
public class ReactorMain {
   public static void main(String[] args) throws InterruptedException {
//      Mono<String> mono = Mono.just("AWDASD");
//
//      mono.subscribeOn(Schedulers.boundedElastic())
//            .subscribe(s -> log.info(s));
//
//      System.out.println("비동기다");
//
//      Mono<String> mono2 = Mono.just("AWDASD2");
//
//      mono2.subscribeOn(Schedulers.boundedElastic()).mergeWith(mono)
//            .subscribe(s -> log.info(s));
//
//      System.out.println("비동기다2");
//
//
//      Thread.sleep(5000);

      Flux.interval(Duration.ofSeconds(1L))
            .subscribeOn(Schedulers.boundedElastic())
//            .doOnError(e -> log.info("Error")) doOnError는 오류 신호를 살펴보는데만 사용됨
            .subscribe(i -> log.info(TempInfo.fetch("New York").toString()), e -> log.info("에러 발생"));

      System.out.println("?");

      Thread.sleep(10000);
   }
}
