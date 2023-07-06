package com.blog.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTestExample {

   public static class User {
      private final String name;
      private final Address address;

      public User(String name, String address) {
         this.name = name;
         this.address = new Address(address);
      }

      public String getName() {
         return name;
      }

      public Address getAddress() {
         return address;
      }
   }

   public static class Address {
      private final String city;

      public Address(String city) {
         this.city = city;
      }

      public String getCity() {
         return city;
      }
   }

   @Test
   @DisplayName("List 테스트")
   void test20230629131424() {
      List<String> testList = Arrays.asList("test1", "test2", "test3");

      assertThat(testList.get(0)).isEqualTo("test1");
   }

   @Test
   @DisplayName("List 테스트 - contain")
   void test20230629131425() {
      List<String> testList = Arrays.asList("test1", "test2", "test3");

      // test1이 포함되어 있나
      assertThat(testList).contains("test1");

      // 순서가 정확해야함
      assertThat(testList).containsExactly("test1", "test2", "test3");

      // 순서는 정확하지 않아도됨
      assertThat(testList).containsExactlyInAnyOrder("test1", "test3", "test2");
   }

//   @Test
//   @DisplayName("List 테스트 - 객체")
//   void test20230629131426() {
//      List<User> testUsers = Arrays.asList(
//            new User("test1", "인천"),
//            new User("test2", "서울"),
//            new User("test3", "강원도")
//      );
//
//      assertThat(testUsers)
//            .extracting("address")
//            .contains("인천", "서울", "강원도");
//
//      assertThat(testUsers)
//            .extracting("address")
//            .containsExactlyInAnyOrder("인천", "강원도", "서울");
//
//      assertThat(testUsers)
//            .extracting(User::getAddress)
//            .containsExactlyInAnyOrder("인천", "강원도", "서울");
//   }

   @Test
   @DisplayName("List 테스트 - 복잡한 객체")
   void test20230629131427() {
      List<User> testUsers = Arrays.asList(
            new User("test1", "인천"),
            new User("test2", "서울"),
            new User("test3", "강원도")
      );

      assertThat(testUsers)
            .extracting("address")
            .extracting("city")
            .contains("인천", "서울", "강원도");

      assertThat(testUsers)
            .extracting(User::getAddress)
            .extracting(Address::getCity)
            .contains("인천", "서울", "강원도");

      assertThat(testUsers)
            .extracting("address.city")
            .contains("인천", "서울", "강원도");
   }
}
