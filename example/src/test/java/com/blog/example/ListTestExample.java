package com.blog.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTestExample {

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
}
