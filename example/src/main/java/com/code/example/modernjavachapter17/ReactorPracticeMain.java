package com.code.example.modernjavachapter17;

import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;


@Slf4j
public class ReactorPracticeMain {
   public static void main(String[] args) throws InterruptedException {

      Flux<Long> onePerSec = Flux.interval(Duration.ofSeconds(1L))
              .subscribeOn(Schedulers.boundedElastic());

      // flux merge

      var one = Flux.just(1);
      var two = Flux.just(2);
      var three = Flux.just(3);

      Flux.merge(one, two, three)
                      .subscribe(i -> log.info(TempInfoNormal.fetch("New York", i).toString()), e -> log.info("에러 발생"));

      log.info("------------------------------------------------------");

      // map
      Flux.just(1)
              .map(i -> i + 30)
              .subscribe(i -> log.info(TempInfoNormal.fetch("New York", i).toString()), e -> log.info("에러 발생"));

      System.out.println("?");

//      Thread.sleep(10000);
   }
}
