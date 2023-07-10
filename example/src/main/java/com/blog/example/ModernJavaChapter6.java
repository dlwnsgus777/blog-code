package com.blog.example;

import com.blog.morden.example.Dish;
import com.blog.morden.example.DishesFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModernJavaChapter6 {
   public static void main(String[] args) {
      List<Dish> menu = DishesFactory.getMenus();

      String shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining());
      System.out.println(shortMenu);
      shortMenu = menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
      System.out.println(shortMenu);

      int totalCalories = menu.stream().collect(Collectors.reducing(
            0, Dish::getCalories, (i, j) -> i + j
      ));
   }
}
