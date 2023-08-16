package com.blog.example;

import java.util.ArrayList;
import java.util.List;

public class ModernJavaChapter15_2 {
   public static void main(String[] args) {
      SimpleCell c2 = new SimpleCell("c2");
      SimpleCell c1 = new SimpleCell("c1");
      SimpleCell c3 = new SimpleCell("c3");

      c1.subscribe(c3);

      c1.onNext(10);
      c2.onNext(20);
      c1.onNext(50);

      System.out.println(c3.value);
   }

   public static class SimpleCell implements Publisher<Integer>, Subscriber<Integer> {
      private int value = 0;
      private String name;
      private List<Subscriber> subscribers = new ArrayList<>();

      public SimpleCell(String name) {
         this.name = name;
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
