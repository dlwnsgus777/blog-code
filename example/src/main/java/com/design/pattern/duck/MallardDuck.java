package com.design.pattern.duck;

public class MallardDuck extends Duck {
   public MallardDuck() {
      flyBehavior = new FlyWithWings();
   }
}
