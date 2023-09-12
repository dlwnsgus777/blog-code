package com.design.factory.version3.chicago;


import com.design.factory.version3.CheesePizza;
import com.design.factory.version3.Pizza;
import com.design.factory.version3.PizzaIngredientFactory;
import com.design.factory.version3.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {
   @Override
   public Pizza createPizza(String item) {
      Pizza pizza = null;
      PizzaIngredientFactory pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

      if (item.equals("cheese")) {
         pizza = new CheesePizza(pizzaIngredientFactory);
         pizza.name = "시카고 스타일 딥 디쉬 치즈 피자";
      }
       return pizza;
   }
}
