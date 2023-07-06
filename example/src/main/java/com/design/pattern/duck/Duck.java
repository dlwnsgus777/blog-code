package com.design.pattern.duck;

public abstract class Duck {
   FlyBehavior flyBehavior;

   public void performFly() {
      flyBehavior.fly();
   }

   public void setFlyBehavior(FlyBehavior flyBehavior) {
      this.flyBehavior = flyBehavior;
   }
}
