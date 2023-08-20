package com.code.example;

import java.util.ArrayList;
import java.util.List;

public class ModernJavaChapter15_2 {
   public static void main(String[] args) {
      SimpleCell c2 = new SimpleCell("c2");
      SimpleCell c1 = new SimpleCell("c1");
      ArithmeticCell c3 = new ArithmeticCell("c3");

      c1.subscribe(c3::setLeft);
      c2.subscribe(c3::setRight);

      c1.onNext(10);
      c2.onNext(20);
      c1.onNext(50);

      System.out.println("C3 left : " + c3.left);
      System.out.println("C3 right : " + c3.right);
   }

   public static class ArithmeticCell extends SimpleCell {
      private int left;
      private int right;

      public ArithmeticCell(String name) {
         super(name);
      }

      public void setLeft(int left) {
         this.left = left;
         onNext(left + this.right);
      }

      public void setRight(int right) {
         this.right = right;
         onNext(right + this.left);
      }
   }

   public static class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {
      private int value = 0;
      private String name;
      private List<Subscriber> subscribers = new ArrayList<>();

      public SimpleCell(String name) {
         this.name = name;
      }

      public int getValue() {
         return value;
      }

      @Override
      public void subscribe(Subscriber<? super Integer> subscriber) {
         subscribers.add(subscriber);
      }

      private void notifyAllSubscribers() {
         subscribers.forEach(subscriber -> subscriber.onNext(this.value));
      }

      @Override
      public void onNext(Integer integer) {
         this.value = integer;
         System.out.println(this.name + " : " + this.value);
         notifyAllSubscribers();
      }
   }

   public interface Publisher<T> {
      void subscribe(Subscriber<? super T> subscriber);
   }

   public interface Subscriber<T> {
      void onNext(T t);
   }

}
