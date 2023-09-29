package com.design.chapter12;

public class DuckSimulator {
  public static void main(String[] args) {
    final DuckSimulator simulator = new DuckSimulator();
    final CountingFactory duckFactory = new CountingFactory();
    simulator.simulate(duckFactory);
  }

  void simulate(final AbstractDuckFactory duckFactory) {
//    final Quackable mallardDuck = duckFactory.createMallardDuck();
//    final Quackable redheadDuck = duckFactory.createRedheadDuck();
//    final Quackable duckCall = duckFactory.createDuckCall();
//    final Quackable rubberDuck = duckFactory.createRubberDuck();
//    final Quackable gooseDuck = new GooseAdapter(new Goose());
//
//    System.out.println("\n 오리 시뮬레이션 게임 (+ 추상 팩토리 )");
//
//    simulate(mallardDuck);
//    simulate(redheadDuck);
//    simulate(duckCall);
//    simulate(rubberDuck);
//    simulate(gooseDuck);

    final Quackable redheadDuck = duckFactory.createRedheadDuck();
    final Quackable duckCall = duckFactory.createDuckCall();
    final Quackable rubberDuck = duckFactory.createRubberDuck();
    final Quackable gooseDuck = new GooseAdapter(new Goose());
//
//    System.out.println("\n 오리 시뮬레이션 게임 (+ 컴포지트)");
//
//    final Flock flockOfDucks = new Flock();
//    flockOfDucks.add(redheadDuck);
//    flockOfDucks.add(duckCall);
//    flockOfDucks.add(rubberDuck);
//    flockOfDucks.add(gooseDuck);
//
//    final Flock flockOfMallards = new Flock();
//
//
//    final Quackable mallardOne = duckFactory.createMallardDuck();
//    final Quackable mallardTwo = duckFactory.createMallardDuck();
//    final Quackable mallardThree = duckFactory.createMallardDuck();
//    final Quackable mallardFour = duckFactory.createMallardDuck();
//
//    flockOfMallards.add(mallardOne);
//    flockOfMallards.add(mallardTwo);
//    flockOfMallards.add(mallardThree);
//    flockOfMallards.add(mallardFour);
//
//    flockOfDucks.add(flockOfMallards);
//
//    System.out.println("\n 오리 시뮬레이션 게임: 전체 무리");
//    simulate(flockOfDucks);
//
//    System.out.println("\n 오리 시뮬레이션 게임: 물오리 무리");
//    simulate(flockOfMallards);



    System.out.println("\n 오리 시뮬레이션 게임 (+ 옵저버)");


    final Quackologist quackologist = new Quackologist();


    final Flock flockOfDucks = new Flock();
    flockOfDucks.add(redheadDuck);
    flockOfDucks.add(duckCall);
    flockOfDucks.add(rubberDuck);
    flockOfDucks.add(gooseDuck);

    flockOfDucks.registerObserver(quackologist);

    flockOfDucks.quack();

    final Flock flockOfMallards = new Flock();


    System.out.println("오리가 소래 낸 횟수 : " + QuackCounter.getQuacks() + " 번");
  }

  void simulate() {
//    final Quackable mallardDuck = new MallardDuck();
//    final Quackable redheadDuck = new RedheadDuck();
//    final Quackable duckCall = new DuckCall();
//    final Quackable rubberDuck = new RubberDuck();
//    final Quackable gooseAdapter = new GooseAdapter(new Goose());
//
//    System.out.println("\n 오리 시뮬레이션 게임 (+ 거위 어댑터)");
//
//    simulate(mallardDuck);
//    simulate(redheadDuck);
//    simulate(duckCall);
//    simulate(rubberDuck);
//    simulate(gooseAdapter);

    final Quackable mallardDuck = new QuackCounter(new MallardDuck());
    final Quackable redheadDuck = new QuackCounter(new RedheadDuck());
    final Quackable duckCall = new QuackCounter(new DuckCall());
    final Quackable rubberDuck = new QuackCounter(new RubberDuck());
    final Quackable gooseAdapter = new GooseAdapter(new Goose());

    System.out.println("\n 오리 시뮬레이션 게임 (+ 데코레이터)");

    simulate(mallardDuck);
    simulate(redheadDuck);
    simulate(duckCall);
    simulate(rubberDuck);
    simulate(gooseAdapter);

    System.out.println("오리가 소래 낸 횟수 : " + QuackCounter.getQuacks() + " 번");

  }

  void simulate(Quackable duck) {
    duck.quack();
  }
}
