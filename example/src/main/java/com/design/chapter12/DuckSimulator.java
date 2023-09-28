package com.design.chapter12;

public class DuckSimulator {
  public static void main(String[] args) {
    final DuckSimulator simulator = new DuckSimulator();
    simulator.simulate();
  }

  void simulate() {
    final Quackable mallardDuck = new MallardDuck();
    final Quackable redheadDuck = new RedheadDuck();
    final Quackable duckCall = new DuckCall();
    final Quackable rubberDuck = new RubberDuck();

    System.out.println("\n 오리 시뮬레이션 게임");

    simulate(mallardDuck);
    simulate(redheadDuck);
    simulate(duckCall);
    simulate(rubberDuck);
  }

  void simulate(Quackable duck) {
    duck.quack();
  }
}
