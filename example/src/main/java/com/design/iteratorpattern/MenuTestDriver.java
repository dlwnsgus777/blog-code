package com.design.iteratorpattern;

public class MenuTestDriver {
  public static void main(String[] args) {
    final PancakeHouseMenu pancakeMenu = new PancakeHouseMenu();
    final DinerMenu dinerMenu = new DinerMenu();
    final CafeMenu cafeMenu = new CafeMenu();

    final Waitress waitress = new Waitress(pancakeMenu, dinerMenu, cafeMenu);

    waitress.printMenu();
  }
}
