package com.design.iteratorpattern;

public class MenuTestDriver {
  public static void main(String[] args) {
    final PancakeHouseMenu pancakeMenu = new PancakeHouseMenu();
    final DinerMenu dinerMenu = new DinerMenu();

    final Waitress waitress = new Waitress(pancakeMenu, dinerMenu);

    waitress.printMenu();
  }
}
