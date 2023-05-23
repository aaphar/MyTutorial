package oop.Abstraction;

public class Main {
    public static void main(String[] args) {

        Dog dog=new Dog("Yorkie");
        dog.breathe();
        dog.eat();

//        cannot directly instantiate abstract class
//        Bird bird=new Bird("Parrot");
//        bird.breathe();
//        bird.eat();

        Parrot parrot=new Parrot("Australian ring-neck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin=new Penguin("Emperor");
        penguin.fly();
    }
}
