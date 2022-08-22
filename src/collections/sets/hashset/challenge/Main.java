package collections.sets.hashset.challenge;

public class Main {
    public static void main(String[] args) {
        Dog rover = new Dog("Rover");
        Labrador rover2 = new Labrador("Rover");

        System.out.println(rover.equals(rover2));
        System.out.println(rover2.equals(rover));
    }
}
