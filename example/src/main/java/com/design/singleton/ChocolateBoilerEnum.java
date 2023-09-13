package com.design.singleton;

public enum ChocolateBoilerEnum {
    INSTANCE;
    private boolean empty;
    private boolean boiled;

    ChocolateBoilerEnum() {
        this.empty = true;
        this.boiled = false;
    }

    public static ChocolateBoilerEnum getInstance() {
        return INSTANCE;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
