package com.design.observer.pull;


public interface Subject {
   void registerObserver(Observer o);
   void removeObserver(Observer o);
   void notifyObservers();
}
