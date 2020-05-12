package practice.interfaces;

public class Test {
    public static void main(String[] args) {
        System.out.println("test world");

        Food food = new Gogi();

        food.eat();
        System.out.println(food.name());
    }
}
