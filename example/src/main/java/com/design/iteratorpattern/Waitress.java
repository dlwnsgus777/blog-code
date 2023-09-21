package com.design.iteratorpattern;

import java.util.Iterator;

public class Waitress {
  Menu pancakeHouseMenu;
  Menu dinerMenu;

  public Waitress(final Menu pancakeHouseMenu, final Menu dinerMenu) {
    this.pancakeHouseMenu = pancakeHouseMenu;
    this.dinerMenu = dinerMenu;
  }

  public void printMenu() {
    final java.util.Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
    final java.util.Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();

    System.out.println("메뉴\n---------\n 아침 메뉴");
    printMenu(pancakeIterator);
    System.out.println("\n점심 메뉴 ");
    printMenu(dinerIterator);
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
