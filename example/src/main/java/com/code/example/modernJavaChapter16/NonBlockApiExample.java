package com.code.example.modernJavaChapter16;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonBlockApiExample {
   public static void main(String[] args) {
//      Shop shop = new Shop("BestShop");
//      long start = System.nanoTime();
//      Future<Double> futurePrice = shop.getPriceAsync("test product");
//      long invocationTime = ((System.nanoTime() - start) / 1_000_000);
//
//      System.out.println("Invocation returned after " + invocationTime  + " mesc");
//
//      // 가격 계산 동안 다른 메서드 수행
//      try {
//         double price = futurePrice.get();
//         System.out.printf("Price is %.2f%n", price);
//      } catch (Exception e) {
//         throw new RuntimeException(e);
//      }
//      long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
//      System.out.println("price returned after " + retrievalTime + " mesc");

      List<Shop> shops = Arrays.asList(
            new Shop("BestPrice"),
            new Shop("LetsSaveBig"),
            new Shop("MyFavorite"),
            new Shop("BuyItAll")
      );
      final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100),
            new ThreadFactory() {
               @Override
               public Thread newThread(Runnable r) {
                  Thread t = new Thread(r);
                  t.setDaemon(true);
                  return t;
               }
            }
      );


      long start = System.nanoTime();
      long invocationTime = ((System.nanoTime() - start) / 1_000_000);

      System.out.println("Invocation returned after " + invocationTime  + " mesc");

      // 가격 계산 동안 다른 메서드 수행
      System.out.println(findPrices("iPhone", shops));


      long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
      System.out.println("price returned after " + retrievalTime + " mesc");
   }

//   public static List<String> findPrices(String product, List<Shop> shops) {
//      return shops.stream()
//            .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
//            .collect(Collectors.toList());
//   }

//   public static List<String> findPrices(String product, List<Shop> shops) {
//      return shops.parallelStream()
//            .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
//            .collect(Collectors.toList());
//   }

//   public static List<String> findPrices(String product, List<Shop> shops) {
//      List<CompletableFuture<String>> priceFutures = shops.stream()
//            .map(shop -> CompletableFuture.supplyAsync(
//                  () -> shop.getName() + " price is " + shop.getPrice(product)
//            )).collect(Collectors.toList());
//
//      return priceFutures.stream()
//            .map(CompletableFuture::join)
//            .collect(Collectors.toList());
//   }

   public static List<String> findPrices(String product, List<Shop> shops) {
      return shops.stream()
            .map(shop -> shop.getPrice(product))
            .map(Quote::parse)
            .map(Discount::applyDiscount)
            .collect(Collectors.toList());
   }

//   public static List<String> findPrices(String product, List<Shop> shops, Executor executor) {
//      List<CompletableFuture<String>> priceFutures = shops.stream()
//            .map(shop -> CompletableFuture.supplyAsync(
//                  () -> shop.getPrice(product), executor))
//            .map(future -> future.thenApply(Quote::parse))
//            .map(future -> future.thenCompose(
//                  quote -> CompletableFuture.supplyAsync(
//                        () -> Discount.applyDiscount(quote), executor
//                  )
//            )).collect(Collectors.toList());
//
//      return priceFutures.stream()
//            .map(CompletableFuture::join)
//            .collect(Collectors.toList());
//   }
   public Stream<CompletableFuture<String>> findPricesStream(String product, List<Shop> shops, Executor executor) {
      return shops.stream()
              .map(shop -> CompletableFuture.supplyAsync(
                      () -> shop.getPrice(product, executor))
              ).map(future -> future.thenApply(Quote::parse))
              .map(future -> future.thenCompose(quote ->
                  CompletableFuture.supplyAsync(
                          () -> Discount.applyDiscount(quote),
                          executor
                  )
              ));
   }
}
