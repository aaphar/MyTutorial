package oop.NestedClass.GinaSprintNestedClassTutorial;

public class OuterClass {
    static int staticField = 0;//static, class level...
    //one instance variable shared among all instance of OuterClass

    int instanceField; //non-static, instance level...
    //each instance of OuterClass gets its own instanceField

    public OuterClass() {
        instanceField = 1;
        System.out.println("Hello from OuterClass constructor.");
    }

    // 1. static nested class
    public static class StaticNestedClass {
        // nested classes are members of enclosing class
        // static nested classes can access static members of enclosing class
        // static nested class ARE NOT ASSOCIATED WITH AN INSTANCE OF THE ENCLOSING CLASS
        // no this reference for static nested class and no this reference for OuterClass


        public StaticNestedClass() {
            System.out.println("Hello from StaticNestedClass constructor");
            System.out.println(staticField);
        }
    }

    // 2. inner class
    public class InnerClass {
        // inner class ARE ASSOCIATED WITH AN INSTANCE OF ENCLOSING CLASS.
        // inner classes can access static and non-static members of enclosing class

        //instance level field
        int instanceField;

        public InnerClass() {
            instanceField = 100;
            System.out.println("Hello from InnerClass constructor");
            System.out.println("staticField: " + staticField);
            System.out.println("instanceField: " + this.instanceField);
            //this refers to this instance of InnerClass

            //OuterClass.this refers to this instance of OuterClass that this instance
            //of InnerClass belongs to
            System.out.println("OuterClass' instanceField: " + OuterClass.this.instanceField);
        }
    }

    // 3. and 4. local classes
    // need a method
    public void instanceMethod() {
        int localVariable = 500;

        localVariable = 999;

        final int finalLocalVariable = localVariable;

        // 3. local class
        class LocalClass {
            // constructor
            public LocalClass() {
                System.out.println("Hello from LocalClass constructor.");

                // local classes can access the local variable of the enclosing method
                // only if the local variable are final or "effectively final"
                System.out.println("localVariable: " + finalLocalVariable);

                // can access outer class's instance variable
                System.out.println("instanceField: " + instanceField);
            }
        }

        //instantiate a LocalClass object
        LocalClass localClass = new LocalClass();


        // 4. anonymous class
        // we need the name of an interface to implement or a class to extent in order
        // to create an anonymous class
        // lets extent object

        Object myAnonymousClassObject = new Object() {
            // override methods

            @Override
            public String toString() {
                return "Hello";
            }
        };

        System.out.println(myAnonymousClassObject);
    }
}
