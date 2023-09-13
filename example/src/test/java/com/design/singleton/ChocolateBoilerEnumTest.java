package com.design.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChocolateBoilerEnumTest {

    @Test
    @DisplayName("초콜릿 보일러 테스트")
    void test20230913124629() {
        ChocolateBoilerEnum chocolateBoiler = ChocolateBoilerEnum.INSTANCE;

        assertThat(chocolateBoiler.isEmpty()).isTrue();
        chocolateBoiler.fill();
        assertThat(chocolateBoiler.isEmpty()).isFalse();
    }
}