package keywords.finals;

public class Main {
    public static void main(String[] args) {
//
//        SomeClass one = new SomeClass("one");
//        SomeClass two = new SomeClass("Two");
//        SomeClass three = new SomeClass("Three");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
////        one.instanceNumber = 9; // cannot change cus it is final
//
//        System.out.println(Math.PI); // PI is public static final - constant
////        Math m = new Math(); // Cus constructor is private
//        // and all field and methods is static final
//        // that is why no need to instantiate Math class,
//        // Math class cannot be subclass cus it is declared as final
//        System.out.println();
//
//        int pw = 674312;
//        Password password = new ExtendedPassword(pw);
//        password.storePassword();
//        password.letMeIn(1);
//        password.letMeIn(674315);
//        password.letMeIn(9876);
//        password.letMeIn(674315);
//        password.letMeIn(674312);

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);

    }
}
