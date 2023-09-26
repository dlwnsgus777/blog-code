package com.design.proxy;

public class GumballMachineTestDrive {
  public static void main(String[] args) {
//    final GumballMachine gumballMachine = new GumballMachine(5);
//
//    System.out.println(gumballMachine);
//
//    gumballMachine.insertQuarter();
//    gumballMachine.turnCrank();
//
//    System.out.println(gumballMachine);
//
//    gumballMachine.insertQuarter();
//    gumballMachine.turnCrank();
//    gumballMachine.insertQuarter();
//    gumballMachine.turnCrank();
//
//    System.out.println(gumballMachine);

    int count = 0;

    if (args.length < 2) {
      System.out.println("GumballMachine <name> <inventory>");
      System.exit(1);
    }

    count = Integer.parseInt(args[1]);
    final GumballMachine gumballMachine = new GumballMachine(args[0], count);

    final GumballMonitor monitor = new GumballMonitor(gumballMachine);

    monitor.report();
  }
}
