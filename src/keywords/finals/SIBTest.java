package keywords.finals;

public class SIBTest {
    public static final String owner;

    // static code block - called always before constructor
    static {
        owner = "tim";
        System.out.println("SIBTest static initialization block called");
    }

    public SIBTest() {
        System.out.println("SIBTest constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
