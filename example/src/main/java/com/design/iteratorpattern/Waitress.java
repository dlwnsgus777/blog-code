package com.design.iteratorpattern;

import java.util.Iterator;

public class Waitress {
  Menu pancakeHouseMenu;
  Menu dinerMenu;
  Menu cafeMenu;

  public Waitress(final Menu pancakeHouseMenu, final Menu dinerMenu, final Menu cafeMenu) {
    this.pancakeHouseMenu = pancakeHouseMenu;
    this.dinerMenu = dinerMenu;
    this.cafeMenu = cafeMenu;
  }

  public void printMenu() {
    final java.util.Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
    final java.util.Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
    final java.util.Iterator<MenuItem> cafeIterator = cafeMenu.createIterator();

    System.out.println("메뉴\n---------\n 아침 메뉴");
    printMenu(pancakeIterator);
    System.out.println("\n점심 메뉴 ");
    printMenu(dinerIterator);
    System.out.println("\n저녁 메뉴 ");
    printMenu(cafeIterator);
  }

  private void printMenu(final Iterator<MenuItem> iterator) {
    while (iterator.hasNext()) {
      final MenuItem menuItem = iterator.next();
      System.out.print(menuItem.getName() + ", ");
      System.out.print(menuItem.getPrice() + " -- ");
      System.out.println(menuItem.getDescription());
    }
  }
}
