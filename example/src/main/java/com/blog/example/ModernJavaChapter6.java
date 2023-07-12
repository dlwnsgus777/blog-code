package com.blog.example;

import com.blog.morden.example.Dish;
import com.blog.morden.example.DishesFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModernJavaChapter6 {
   public static void main(String[] args) {
      List<Dish> menu = DishesFactory.getMenus();

      String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
      System.out.println(shortMenu);
      shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
      System.out.println(shortMenu);

//      int totalCalories = menu.stream().collect(Collectors.reducing(
//            0, Dish::getCalories, (i, j) -> i + j
//      ));

      int totalCalories = menu.stream().collect(Collectors.reducing(
            0, // 초기값
            Dish::getCalories, // 변환 함수
            Integer::sum // 합계 함수
      ));

      Optional<Dish> mostCalorieDish = menu.stream().collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

      Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(Collectors.groupingBy(Dish::getType));

//      Map<Dish.Type, List<Dish>> caloricDishedByType = menu.stream()
//            .filter(dish -> dish.getCalories() > 500)
//            .collect(Collectors.groupingBy(Dish::getType));

      Map<Dish.Type, List<Dish>> caloricDishedByType = menu.stream()
            .collect(Collectors.groupingBy(Dish::getType,
                  Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));

      Map<Dish.Type, List<String>> dishNamesByType = menu.stream().collect(
            Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList()))
      );

      Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
            Collectors.groupingBy(
                  Dish::getType,
                  Collectors.groupingBy(dish -> {
                     if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                     } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                     } else {
                        return CaloricLevel.FAT;
                     }
                  })
            )
      );

      Map<Dish.Type, Long> typesCount = menu.stream().collect(
            Collectors.groupingBy(Dish::getType, Collectors.counting())
      );

      Map<Dish.Type, Dish> mostCaloricByType = menu.stream().collect(
            Collectors.groupingBy(
                  Dish::getType,
                  Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get
                  )
            )
      );

      Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));

      Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishedByType = menu.stream().collect(
            Collectors.partitioningBy(Dish::isVegetarian,
                  Collectors.groupingBy(Dish::getType))
      );

      menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian,
                            Collectors.partitioningBy(d -> d.getCalories() > 500)));

   }
   public enum CaloricLevel {
      DIET,
      NORMAL,
      FAT
   }
}
