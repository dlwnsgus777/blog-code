package com.design.chapter12;

public class GooseAdapter implements Quackable{
  Goose goose;

  public GooseAdapter(final Goose goose) {
    this.goose = goose;
  }

  @Override
  public void quack() {
    goose.honk();
  }
}
