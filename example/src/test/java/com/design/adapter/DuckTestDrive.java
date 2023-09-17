package com.design.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuckTestDrive {
  @Test
  @DisplayName("어뎁터 패턴 테스트")
  void test20230917214110() {
    Duck duck = new MallardDuck();

    Turkey turkey = new WildTurkey();
    Duck turkeyAdapter = new TurkeyAdapter(turkey);

    System.out.println("칠면조가 말하길");
    turkey.gobble();
    turkey.fly();

    System.out.println("\n 오리가 말하길");
    duck.quack();
    duck.fly();

    System.out.println("\n 칠면조 어댑터가 말하길");
    testDuck(turkeyAdapter);

  }

  private void testDuck(Duck duck) {
    duck.quack();
    duck.fly();
  }
}