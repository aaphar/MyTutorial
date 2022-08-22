package oop.Abstraction;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // if it is common for all instance of class then, use abstract methode
    // otherwise create interface and use the method inside it,
    // and implement interface when you need

    public abstract void eat();
    public abstract void breathe();

    public String getName() {
        return name;
    }

    /**
     * abstract class can have member variables that are inherited,
     * but can't be done in interfaces
     *
     * interfaces can have variables, but they are all public static final variables
     * which essentially are going to be constant values that should never have changed
     * with a static scope.
     * They have to be static, because non-static variables require an instance, and
     * of course, you can't instantiate interface.
     *
     * Interfaces also cannot have constructor, but abstract class can.
     *
     * All methods of interface are automatically public and abstract.
     * Whereas the methods of an abstract class can have any visibility.
     *
     * Abstract class can have defined methods with an implementation. getName().
     * Whereas all methods in an interface are abstract.
     *
     */
}
