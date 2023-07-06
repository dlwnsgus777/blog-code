package com.design.pattern.duck;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MallardDuckTest {

   @Test
   @DisplayName("오리가 나는 테스트")
   void test20230707081530() {
      Duck duck = new MallardDuck();
      duck.performFly();
   }
}