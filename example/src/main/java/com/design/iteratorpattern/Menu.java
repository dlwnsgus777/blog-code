package com.design.iteratorpattern;

import java.util.Iterator;

public interface Menu {
  public Iterator<MenuItem> createIterator();
}
