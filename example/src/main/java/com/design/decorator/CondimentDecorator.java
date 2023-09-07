package com.design.decorator;

public abstract class CondimentDecorator extends Beverage{
   Beverage beverage;

   public abstract String getDescription();
}
