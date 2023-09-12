package com.design.factory.version3.nystyle;


import com.design.factory.version3.CheesePizza;
import com.design.factory.version3.Pizza;
import com.design.factory.version3.PizzaIngredientFactory;
import com.design.factory.version3.PizzaStore;

public class NYStylePizzaStore extends PizzaStore {
   @Override
   public Pizza createPizza(String item) {
      Pizza pizza = null;
      PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();

      if (item.equals("cheese")) {
         pizza = new CheesePizza(pizzaIngredientFactory);
         pizza.name = "뉴욕 스타일 치즈 피자";
      }

      return pizza;
   }
}
