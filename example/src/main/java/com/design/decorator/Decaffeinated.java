package com.design.decorator;

public class Decaffeinated extends Beverage{
   public Decaffeinated() {
      description = "디카페인 커피";
   }

   @Override
   public double cost() {
      return 1.05;
   }
}
