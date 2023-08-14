package com.blog.example;

public class ModernJavaChapter13 {
   public static void main(String[] args) {
      Ttt ttt = new Ttt();

      Test.test();
//      ttt.test(); => 컴파일 에러

      ttt.test1();
   }


   public interface Test {
      static void test() {
         System.out.println("test");
      }

      default void test1() {
         System.out.println("test1");
      }
   }

   public static class Ttt implements Test {

   }
}
