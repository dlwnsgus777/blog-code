package com.design.chapter12;

public class GooseAdapter implements Quackable{
  Observable observable;

  Goose goose;

  public GooseAdapter(final Goose goose) {
    observable = new Observable(this);
    this.goose = goose;
  }

  @Override
  public void quack() {
    goose.honk();
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
