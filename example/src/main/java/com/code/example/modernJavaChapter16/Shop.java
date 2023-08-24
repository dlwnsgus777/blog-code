package com.code.example.modernJavaChapter16;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Shop {
   private Random random = new Random();
   private String name;
   public Shop(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

//   public double getPrice(String product) {
//      return calculatePrice(product);
//   }

   public String getPrice(String product) {
      double price = calculatePrice(product);
      Discount.Code code = Discount.Code.values()[
            random.nextInt(Discount.Code.values().length)
            ];
      return String.format("%s:%.2f:%s", name, price, code);
   }

//   public Future<Double> getPriceAsync(String product) {
//      CompletableFuture<Double> futurePrice = new CompletableFuture<>();
//      new Thread(() -> {
//         double price = calculatePrice(product);
//         futurePrice.complete(price);
//      }).start();
//
//      return futurePrice;
//   }

   public Future<Double> getPriceAsync(String product) {
      return CompletableFuture.supplyAsync(() -> calculatePrice(product));
   }

   public static void delay() {
      try {
         Thread.sleep(1000L);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
   }

   private double calculatePrice(String product) {
      delay();
      return random.nextDouble() * product.charAt(0) + product.charAt(1);
   }
}
