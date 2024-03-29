package com.design.statepattern;

public interface State {
  void insertQuarter();
  void ejectQuarter();
  void turnCrank();
  void dispense();
}
