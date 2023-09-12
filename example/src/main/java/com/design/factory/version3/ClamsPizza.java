package com.design.factory.version3;

public class ClamsPizza extends Pizza{
  PizzaIngredientFactory pizzaIngredientFactory;

  public ClamsPizza(PizzaIngredientFactory pizzaIngredientFactory) {
    this.pizzaIngredientFactory = pizzaIngredientFactory;
  }

  @Override
  public void prepare() {
    System.out.println("준비 중: " + name);
    dough = pizzaIngredientFactory.createDough();
    sauce = pizzaIngredientFactory.createSauce();
    cheese = pizzaIngredientFactory.createCheese();
    clams = pizzaIngredientFactory.createClams();
  }
}
