package com.design.templatemethod;

public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void addCondiments();

    abstract void brew();

    void pourInCup() {
        System.out.println("컵에 따르는 중");
    }

    void boilWater() {
        System.out.println("물 끓이는 중");
    }

    boolean customerWantsCondiments() {
        return true;
    }
}
