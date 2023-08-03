package com.blog.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ModernJavaChapter1 {
   public static void main(String[] args) {
      List<Apple> inventory = new ArrayList<>();
      List<Integer> integers = new ArrayList<>();

//		List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
//			@Override
//			public boolean test(Apple apple) {
//				return Color.RED.equals(apple.getColor());
//			}
//		});

      List<Apple> redApples = filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
      List<Integer> filterdInteger = filter(integers, (Integer i) -> i % 2 == 0);
   }
   public static List<Apple> filterGreenApples(List<Apple> inventory, Color color) {
      List<Apple> result = new ArrayList<>();
      for (Apple apple : inventory) {
         if (color.equals(apple.getColor())) {
            result.add(apple);
         }
      }
      return result;
   }

   public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
      List<Apple> result = new ArrayList<>();
      for (Apple apple : inventory) {
         if (applePredicate.test(apple)) {
            result.add(apple);
         }
      }
      return result;
   }

   public interface Predicate<T> {
      boolean test(T t);
   }

   public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
      List<T> result = new ArrayList<>();
      for (T t : list) {
         if (predicate.test(t)) {
            result.add(t);
         }
      }
      return result;
   }


   @Getter
   @AllArgsConstructor
   private static class Apple {
      private  Color color;
      private  int weight;

      Apple(int weight) {
         this.weight = weight;
      }

   }

   interface ApplePredicate {
      boolean test(Apple apple);
   }

   private static class AppleGreenColorPredicate implements ApplePredicate {

      @Override
      public boolean test(Apple apple) {
         return Color.GREEN.equals(apple.getColor());
      }
   }
}
