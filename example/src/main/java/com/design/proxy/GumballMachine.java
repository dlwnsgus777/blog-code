package com.design.proxy;

public class GumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state;
    int count = 0;
    String location;

    public GumballMachine(final String location, final int numberGumballs) {
       soldOutState = new SoldOutState(this);
       noQuarterState = new NoQuarterState(this);
       hasQuarterState = new HasQuarterState(this);
       soldState = new SoldOutState(this);
       winnerState = new WinnerState(this);

       this.count = numberGumballs;
       if (numberGumballs > 0) {
           state = noQuarterState;
       } else {
           state = hasQuarterState;
       }

       this.location = location;
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("알맹이를 내보내고 있습니다.");
        if (count > 0) {
            count = count - 1;
        }
    }

    public void setState(final State state) {
        this.state = state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }

    public String getLocation() {
        return location;
    }

    public String getState() {
        if (state instanceof NoQuarterState) {
            return "동전 대기 중";
        }

        if (state instanceof HasQuarterState) {
            return "동전 들어감";
        }

        if (state instanceof SoldOutState) {
            return "재고 없음";
        }

        return null;
    }
}
