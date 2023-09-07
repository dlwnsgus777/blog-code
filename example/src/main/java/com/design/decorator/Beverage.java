package com.design.decorator;

public abstract class Beverage {
   String description = "제목 없음";

   public String getDescription() {
      return description;
   }

   public abstract double cost();
}
