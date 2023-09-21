package com.design.iteratorpattern;

import java.util.List;

public class PancakeHouseIterator implements Iterator{
  List<MenuItem> items;
  int position = 0;

  public PancakeHouseIterator(final List<MenuItem> items) {
    this.items = items;
  }

  @Override
  public boolean hasNext() {
    if (position >= items.size()) {
      return false;
    }
    return true;
  }

  @Override
  public MenuItem next() {
    final MenuItem menuItem = items.get(position);
    position = position + 1;
    return menuItem;
  }
}
