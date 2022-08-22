package collections.UnboxingAutoboxing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            integers.add(Integer.valueOf(i));//autoboxing primitive->Wrapper
        }
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i).intValue());//unboxing Wrapper->primitive
        }


        Integer integer = 56; //Integer.valueOf(56) -> compile time process
        int myInt = integer.intValue(); //integer.intValue() -> unboxing

        ArrayList<Double> doubleArrayList = new ArrayList<>();
        for (double i = 0.0; i < 10.0; i++) {
            doubleArrayList.add(Double.valueOf(i));//autoboxing
        }

        for (int i = 0; i < doubleArrayList.size(); i++) {
            double value = doubleArrayList.get(i).doubleValue();//unboxing
            System.out.println(value);
        }

    }
}

/**
 * Autoboxing - primitive type to Wrapper class;
 * Unboxing - Wrapper class to primitive value;
 */