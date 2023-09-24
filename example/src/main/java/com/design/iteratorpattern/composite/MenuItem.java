package com.design.iteratorpattern.composite;

public class MenuItem extends MenuComponent{
  String name;
  String description;
  double price;
  boolean vegetarian;

  public MenuItem(final String name, final String description, final double price, final boolean vegetarian) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.vegetarian = vegetarian;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public double getPrice() {
    return price;
  }

  @Override
  public boolean isVegetarian() {
    return vegetarian;
  }

  @Override
  public void print() {
    System.out.println(" " + getName());
    if (isVegetarian()) {
      System.out.println("(v)");
    }
    System.out.println("," + getPrice());
    System.out.println(" --" + getDescription());
  }
}
