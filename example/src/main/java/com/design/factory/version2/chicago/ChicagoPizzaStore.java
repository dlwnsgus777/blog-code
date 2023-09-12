package com.design.factory.version2.chicago;


import com.design.factory.version2.Pizza;
import com.design.factory.version2.PizzaStore;
import com.design.factory.version2.nystyle.NYStyleCheesePizza;

public class ChicagoPizzaStore extends PizzaStore {
   @Override
   public Pizza createPizza(String item) {
//      if (item.equals("cheese")) {
//         return new NYStyleCheesePizza();
//      } else if (item.equals("veggie")) {
//         return new NYStyleVeggiePizza();
//      } else if (item.equals("clam")) {
//         return new NYStyleClamPizza();
//      } else if (item.equals("pepperoni")) {
//         return new NYStylePepperoniPizza();
//      } else return null;

      if (item.equals("cheese")) {
         return new ChicagoStyleCheesePizza();
      }
       return null;
   }
}
