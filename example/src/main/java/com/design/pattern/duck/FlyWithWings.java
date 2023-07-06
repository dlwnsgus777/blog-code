package com.design.pattern.duck;

public class FlyWithWings implements FlyBehavior {
   @Override
   public void fly() {
      System.out.println("날개를 사용해 난다.");
   }
}
