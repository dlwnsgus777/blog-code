package com.code.example.mordernjavacahpter17;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.TimeUnit;


@Slf4j
public class ReactorMain {
   public static void main(String[] args) throws InterruptedException {
      Mono<String> mono = Mono.just("AWDASD");

      mono.subscribeOn(Schedulers.boundedElastic())
            .subscribe(s -> log.info(s));

      System.out.println("비동기다");

      Mono<String> mono2 = Mono.just("AWDASD2");

      mono2.subscribeOn(Schedulers.boundedElastic()).mergeWith(mono)
            .subscribe(s -> log.info(s));

      System.out.println("비동기다2");


      Thread.sleep(5000);
   }
}
