package com.blog.example;

import com.blog.morden.example.Dish;
import com.blog.morden.example.DishesFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModernJavaChapter9 {
   public static void main(String[] args) {
      int a = 10;
      Runnable r1 = () -> {
         // int a = 2; 컴파일 에러 
         System.out.println(a);
      };

      Runnable r2 = new Runnable() {
         @Override
         public void run() {
            int a = 2;
            System.out.println(a);
         }
      };

      String oneLine = processFile(b -> b.readLine());
      String twoLine = processFile(b -> b.readLine( + b.readLine()));
   }

   public static String processFile(ModernJavaChapter91.BufferedReaderProcessor p) throws IOException {
      try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
         return p.process(br);
      }
   }

   public interface BufferedReaderProcessor {
      String process(BufferedReader b) throws IOException;
   }
}
