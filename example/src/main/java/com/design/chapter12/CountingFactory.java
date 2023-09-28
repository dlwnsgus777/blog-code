package com.design.chapter12;

public class CountingFactory extends AbstractDuckFactory {
  @Override
  public Quackable createMallardDuck() {
    return new QuackCounter(new MallardDuck());
  }

  @Override
  public Quackable createRedheadDuck() {
    return new QuackCounter(new RedheadDuck());
  }

  @Override
  public Quackable createDuckCall() {
    return new QuackCounter(new DuckCall());
  }

  @Override
  public Quackable createRubberDuck() {
    return new QuackCounter(new RubberDuck());
  }
}
