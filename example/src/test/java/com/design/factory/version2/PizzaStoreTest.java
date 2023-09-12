package com.design.factory.version2;

import com.design.factory.version2.chicago.ChicagoPizzaStore;
import com.design.factory.version2.nystyle.NYStylePizzaStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaStoreTest {

    @Test
    @DisplayName("피자 코드 테스트")
    void test20230912125458() {
        //given
        PizzaStore nyStore = new NYStylePizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("에단이 주문한 " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("조엘이 주문한 " + pizza.getName() + "\n");
    }
}