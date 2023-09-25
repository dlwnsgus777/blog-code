package com.design.statepattern;

public class HasQuarterState implements State {
  GumballMachine gumballMachine;

  public HasQuarterState(final GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("동전은 한개만 넣어주세요.");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("동전이 반환됩니다.");
    gumballMachine.setState(gumballMachine.getNoQuarterState());
  }

  @Override
  public void turnCrank() {
    System.out.println("손잡이를 돌리셨습니다.");
    gumballMachine.setState(gumballMachine.getSoldState());
  }

  @Override
  public void dispense() {
    System.out.println("알맹이를 내보낼 수 없습니다.");
  }
}
