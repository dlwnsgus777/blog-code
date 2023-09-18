package com.design.principleofleastknowledge;

public class Car {
    Engine engine;
    // 기타 인스턴스 변수

    public Car() {
        // 엔진 초기화 등을 처리
    }

    public void start(Key key) {
        Doors doors = new Doors(); // 직접 생성한 객체의 메서드는 호출해도 된다.
        boolean authorized = key.turns(); // 매개변수로 전달된 객체의 메서드는 호출해도 된다.
        if(authorized) {
            engine.start(); // 구성요소인 객체의 메서드는 호출해도 된다.
            updateDashboardDisplay();   // 객체 내에 있는 메서드는 호출해도 된다.
            doors.lock();   // 직접 생성한 객체의 메서드는 호출해도 된다.
        }
    }

    private void updateDashboardDisplay() {
        // 디스 플레이 갱신
    }
}
