package com.design.chapter12;

public interface QuackObservable {
  public void registerObserver(Observer observer);
  public void notifyObservers();
}
