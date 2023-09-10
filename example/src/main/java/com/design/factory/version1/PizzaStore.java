package com.design.factory.version1;

import com.design.factory.CheesPizza;
import com.design.factory.GreekPizza;
import com.design.factory.Pepperoni;
import com.design.factory.Pizza;

public class PizzaStore {

   public Pizza orderPizza(String type) {
      Pizza pizza = null;

      if (type.equals("cheese")) {
         pizza = new CheesPizza();
      } else if (type.equals("greek")) {
         pizza = new GreekPizza();
      } else if (type.equals("pepperoni")) {
         pizza = new Pepperoni();
      }

      pizza.prepare();
      pizza.bake();
      pizza.cut();
      pizza.box();
      return pizza;
   }

}
