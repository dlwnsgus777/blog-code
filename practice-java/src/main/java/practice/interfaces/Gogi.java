package practice.interfaces;

public class Gogi implements Food {

    private String name;
    private Beaf beaf;

    public Gogi() {
        this.name = "pork";
        this.beaf = new Beaf();
    }

    @Override
    public void eat() {
        System.out.println("this is gogi");
    }

    @Override
    public String name() {
        this.setName("pork 333333");
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
