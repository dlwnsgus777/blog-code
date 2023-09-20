package com.design.templatemethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTestDrive {
    @Test
    @DisplayName("템플릿 메서드 패턴 테스트")
    void test20230920084933() {
        CoffeeWithHook coffeeHook = new CoffeeWithHook();
        System.out.println("커피 준비 중");
        coffeeHook.prepareRecipe();

    }
}