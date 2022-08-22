package collections.array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

    private static Scanner s = new Scanner(System.in);
    private static int[] baseData = new int[10];

    public static void main(String[] args) {

        int[] array = {4, 13, 8, 9, 7, 1, 6};
        printArray(array);

        System.out.println();

        int[] sortedArray = sortAndChangeIndex(array);
        printArray(sortedArray);

//        System.out.println("Enter 10 integer: ");
//        getInput();
//        printArray(baseData);
//        resizeArray();
//        System.out.println("\nEnter 12 integer: ");
//        getInput();
//        printArray(baseData);

//        int[] array={1, 2, 3, 4, 5};
//        reverse(array);


//        int[] array = getInteger(5);
//        int[] sortedArray = sortIntegers(array);
//        printArray(sortedArray);
//
//        System.out.println(array.getClass().getName());
    }

    public static int[] sortAndChangeIndex(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp = 0;

        while (flag) {
            flag = false;

            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                    if(i==2){

                    }
                }
            }
        }

        for (int i = 1; i < sortedArray.length - 1; i++) {
            temp = sortedArray[i];
            sortedArray[i] = sortedArray[i + 1];
            sortedArray[i + 1] = temp;
        }
        return sortedArray;
    }

    private static void getInput() {
        for (int i = 0; i < baseData.length; i++) {
            baseData[i] = s.nextInt();
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] getInteger(int number) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + number + " integer values. \r");
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static int[] sortIntegers(int[] array) {
//        int[] sortedArray = new int[array.length];
//
//        for (int i = 0; i < sortedArray.length; i++) {
//            sortedArray[i] = array[i];
//        }

        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;

        while (flag) {
            flag = false;
            int temp = 0;
            for (int j = 0; j < sortedArray.length - 1; j++) {
                if (sortedArray[j] < sortedArray[j + 1]) {
                    temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                    flag = true;
                }
            }
        }

        return sortedArray;
    }


    public static double getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / (double) array.length;
    }

    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the number of elements: \r");
        int number = scanner.nextInt();
        return number;
    }

    private static int[] readElements(int number) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[number];

        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static int findMin(int[] array) {
        array = readElements(readInteger());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static void reverse(int[] array) {
        System.out.print("Array = " + Arrays.toString(array));

        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        System.out.print("\nReversed array = " + Arrays.toString(array));
    }

    private static void resizeArray() {
        int[] original = baseData;
        baseData = new int[12];
        for (int i = 0; i < original.length; i++) {
            baseData[i] = original[i];
        }
    }
}
