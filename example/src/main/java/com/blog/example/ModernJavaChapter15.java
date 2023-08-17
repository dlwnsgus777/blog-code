package com.blog.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ModernJavaChapter15 {
//   public static void main(String[] args) {
//      ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//
//
//      work1();
//      scheduledExecutorService.schedule(
//              ModernJavaChapter15::work2,
//              10,
//              TimeUnit.SECONDS
//      );
//
//      System.out.println("??");
//      scheduledExecutorService.shutdown();
//
//   }
//
//   public static void work1() {
//      System.out.println("work1!");
//   }
//
//   public static void work2() {
//      System.out.println("work2!");
//   }

   public static void main(String[] args) {
      ExecutorService executorService = Executors.newFixedThreadPool(10);
      int x = 1337;

      CompletableFuture<Integer> a = new CompletableFuture<>();
      CompletableFuture<Integer> b = new CompletableFuture<>();
      CompletableFuture<Integer> c = a.thenCombine(b, (y, z) -> y + z);
      executorService.submit(() -> a.complete(f(x)));
      executorService.submit(() -> b.complete(g(x)));

      System.out.println(c.get());

      executorService.shutdown();
   }
}
