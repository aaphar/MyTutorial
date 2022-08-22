package keywords.finals;

public class SomeClass {
    private static int classCounter = 0; // static value
    public final int instanceNumber; // final value
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
