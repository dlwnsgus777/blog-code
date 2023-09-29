package com.design.chapter12;

public class MallardDuck implements Quackable {
  Observable observable;

  public MallardDuck() {
    observable = new Observable(this);
  }

  @Override
  public void quack() {
    System.out.println("꽥꽥");
    notifyObservers();
  }

  @Override
  public void registerObserver(final Observer observer) {
    observable.registerObserver(observer);
  }

  @Override
  public void notifyObservers() {
    observable.notifyObservers();
  }
}
