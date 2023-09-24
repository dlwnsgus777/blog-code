package com.design.iteratorpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent{
  List<MenuComponent> menuComponents = new ArrayList<>();
  String name;
  String description;

  public Menu(final String name, final String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public void add(final MenuComponent menuComponent) {
    menuComponents.add(menuComponent);
  }

  @Override
  public void remove(final MenuComponent menuComponent) {
    menuComponents.remove(menuComponent);
  }

  @Override
  public MenuComponent getChild(final int i) {
    return menuComponents.get(i);
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
  public void print() {
    System.out.print("\n" + getName());
    System.out.println(", " + getDescription());
    System.out.println("-------------------------------");

    for (MenuComponent menuComponent : menuComponents) {
      menuComponent.print();
    }
  }
}
