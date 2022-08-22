package oop.NestedClass.GinaSprintNestedClassTutorial;

public class Main {
    public static void main(String[] args) {

//        OuterClass outerClass=new OuterClass();
//        System.out.println(outerClass.instanceField);

        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();

        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        outerClass.instanceMethod();
    }
}
