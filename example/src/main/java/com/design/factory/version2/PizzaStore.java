package com.design.factory.version2;

import com.design.factory.CheesPizza;
import com.design.factory.GreekPizza;
import com.design.factory.Pepperoni;
import com.design.factory.Pizza;

public abstract class PizzaStore {

   public Pizza orderPizza(String type) {
      Pizza pizza = createPizza(type);

      pizza.prepare();
      pizza.bake();
      pizza.cut();
      pizza.box();
      return pizza;
   }

   abstract Pizza createPizza(String type);

}
