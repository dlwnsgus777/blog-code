package com.design.proxy.dating;

import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {
  public static void main(String[] args) {
      final MatchMakingTestDrive testDrive = new MatchMakingTestDrive();
      testDrive.drive();
  }

  public void drive() {
    final Person joe = new PersonImpl("joe", "남자", "볼링, 바둑");
    final Person kim = new PersonImpl("김자바", "남자", "독서");
    final Person ownerProxy = getOwnerProxy(joe);

    System.out.println("이름 : " + ownerProxy.getName());
    ownerProxy.setInterests("바둑");
    System.out.println("본인 프록시에 관심 사항을 등록합니다.");

    try {
      ownerProxy.setGeekRating(10);
    } catch (Exception e) {
      System.out.println("본인 프록시에는 괴짜 지수를 매길 수 없습니다.");
    }
    System.out.println("괴짜 지수: " + ownerProxy.getGeekRating());

    final Person nonOwnerProxy = getNonOwnerProxy(kim);
    System.out.println("이름 : " + nonOwnerProxy.getName());
    try {
      nonOwnerProxy.setInterests("볼링, 바둑");
    } catch (Exception e) {
      System.out.println("타인 프록시에는 관심 사항을 등록할 수 없습니다.");
    }
    nonOwnerProxy.setGeekRating(3);
    System.out.println("타인 프록시에 괴짜 지수를 매깁니다.");
    System.out.println("괴짜 지수: " + nonOwnerProxy.getGeekRating());
  }

  private Person getOwnerProxy(final Person person) {
    return (Person) Proxy.newProxyInstance(
            person.getClass().getClassLoader(),
            person.getClass().getInterfaces(),
            new OwnerInvocationHandler(person)
    );
  }

  private Person getNonOwnerProxy(final Person person) {
    return (Person) Proxy.newProxyInstance(
            person.getClass().getClassLoader(),
            person.getClass().getInterfaces(),
            new NonOwnerInvocationHandler(person)
    );
  }
}
