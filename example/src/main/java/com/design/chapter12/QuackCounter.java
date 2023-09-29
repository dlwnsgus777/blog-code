package com.design.chapter12;

public class QuackCounter implements Quackable {
  Quackable duck;
  static int numberOfQuacks;

  public QuackCounter(final Quackable duck) {
    this.duck = duck;
  }

  @Override
  public void quack() {
    duck.quack();
    numberOfQuacks++;
  }

  public static int getQuacks() {
    return numberOfQuacks;
  }

  @Override
  public void registerObserver(final Observer observer) {
    duck.registerObserver(observer);
  }

  @Override
  public void notifyObservers() {
    duck.notifyObservers();
  }
}
