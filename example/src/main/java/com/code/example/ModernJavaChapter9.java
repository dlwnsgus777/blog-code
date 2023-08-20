package com.code.example;

import java.io.BufferedReader;
import java.io.IOException;

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

//      String oneLine = processFile(b -> b.readLine());
//      String twoLine = processFile(b -> b.readLine( + b.readLine()));
   }

//   public static String processFile(ModernJavaChapter91.BufferedReaderProcessor p) throws IOException {
//      try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
//         return p.process(br);
//      }
//   }

   public interface BufferedReaderProcessor {
      String process(BufferedReader b) throws IOException;
   }
}
