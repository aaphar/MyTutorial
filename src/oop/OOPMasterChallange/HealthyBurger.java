package oop.OOPMasterChallange;

public class HealthyBurger extends Hamburger {

    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price, "Brown rye");
    }

    public void addHealthyAddition1(String healthy1ExtraName, double healthy1ExtraPrice) {
        this.healthyExtra1Name = healthy1ExtraName;
        this.healthyExtra1Price = healthy1ExtraPrice;
        super.addHamburgerAddition1(this.healthyExtra1Name, this.healthyExtra1Price);
    }

    public void addHealthyAddition2(String healthyExtra2Name, double healthyExtra2Price) {
        this.healthyExtra2Name = healthyExtra2Name;
        this.healthyExtra2Price = healthyExtra2Price;
        super.addHamburgerAddition2(this.healthyExtra2Name, this.healthyExtra2Price);
    }

    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger();
    }
}
