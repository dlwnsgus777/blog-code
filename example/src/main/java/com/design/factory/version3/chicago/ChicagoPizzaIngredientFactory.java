package com.design.factory.version3.chicago;

import com.design.factory.version3.*;
import com.design.factory.version3.nystyle.*;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
  @Override
  public Dough createDough() {
    return new FatCrustDough();
  }

  @Override
  public Sauce createSauce() {
    return new FlumTomatoSauce();
  }

  @Override
  public Cheese createCheese() {
    return new ReggianoCheese();
  }

  @Override
  public Veggies[] createVeggies() {
    Veggies veggies[] = {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
    return veggies;
  }

  @Override
  public Pepperoni createPepperoni() {
    return new SlicedPepperoni();
  }

  @Override
  public Clams createClams() {
    return new FreezeClams();
  }
}
