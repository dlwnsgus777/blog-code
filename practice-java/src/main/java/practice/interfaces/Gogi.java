package practice.interfaces;

public class Gogi implements Food {

    private String name = "beaf";
    private Beaf beaf = new Beaf();

    @Override
    public void eat() {
        System.out.println("this is gogi");
    }

    @Override
    public String name() {
        return this.beaf.getName();
    }
}
