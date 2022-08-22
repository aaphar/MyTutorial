package oop.Encapsulation;

public class EnhancedPlayer {
    /**
     * without private, we can change them from Main class. also we made any change for any field
     * in EnhancePlayer class we have to change it in all other classes which we use it.
     * But encapsulation make this easy.
     */
    private String name;
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if (health > 0 && health <= 100) {
            this.hitPoints = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.hitPoints = this.hitPoints - damage;
        if (this.hitPoints <= 0) {
            System.out.println("Player knocked out");
        }
    }

    public int getHitPoints() {
        return hitPoints;
    }

}
