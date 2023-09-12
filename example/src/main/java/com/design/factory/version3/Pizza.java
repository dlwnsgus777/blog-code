package com.design.factory.version3;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
   public String name;
   public Dough dough;
   public Sauce sauce;
   public Cheese cheese;
   public Clams clams;
   public List<String> toppings = new ArrayList<>();
   public abstract void prepare();
   public void bake() {
      System.out.println("175도에서 25분 간 굽기");
   }
   public void cut() {
      System.out.println("피자를 사선으로 자르기");
   }
   public void box() {
      System.out.println("상자에 피자 담기");
   }

   public String getName() {
      return name;
   }
}
