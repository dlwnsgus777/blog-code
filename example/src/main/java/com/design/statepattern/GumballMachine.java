package com.design.statepattern;

public class GumballMachine {
    final static int SOLE_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLE_OUT;
    int count = 0;

    public GumballMachine(final int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("동전은 한 개만 넣어 주세요.");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("동전을 넣으셨습니다.");
        } else if (state == SOLE_OUT) {
            System.out.println("매진되었습니다. 다음 기회에 이용해 주세요.");
        } else if (state == SOLD) {
            System.out.println("알맹이를 내보내고 있습니다.");
        }
    }

    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("동전이 반환됩니다.");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어주세요.");
        } else if (state == SOLE_OUT) {
            System.out.println("동전을 넣지 않으셨습니다. 동전이 반혼되지 않습니다.");
        } else if (state == SOLD) {
            System.out.println("이미 알맹이를 뽑으셨습니다.");
        }
    }

    public void turnCrank() {
        if (state == HAS_QUARTER) {
            System.out.println("손잡이를 돌리셨습니다.");
            state = SOLD;
            dispense();
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어주세요.");
        } else if (state == SOLE_OUT) {
            System.out.println("매진 되었습니다.");
        } else if (state == SOLD) {
            System.out.println("손잡이는 한 번만 돌려 주세요.");
        }
    }

    public void dispense() {
        if (state == SOLD) {
            System.out.println("알맹이를 내보내고 있습니다.");
            count = count - 1;
            if (count == 0) {
                System.out.println("더 이상 알맹이가 없습니다.");
                state = SOLE_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("동전을 넣어 주세요.");
        } else if (state == SOLE_OUT) {
            System.out.println("매진입니다.");
        } else if (state == HAS_QUARTER) {
            System.out.println("알맹이를 내보낼 수 없습니다.");
        }
    }
}
