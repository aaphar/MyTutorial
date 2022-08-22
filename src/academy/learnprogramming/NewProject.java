package academy.learnprogramming;

import java.util.Scanner;

public class NewProject {
    public static void main(String[] args) {

        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));

    }

    public static int getBucketCount(double width, double height,
                                      double arePerBucket, int extraBucket) {
        if(width<=0 || height<=0 || arePerBucket<=0 || extraBucket<0)
            return -1;

        int bucket= (getBucketCount(width, height, arePerBucket)-extraBucket);
        return bucket;
    }

    public static int getBucketCount(double width, double height,
                                      double arePerBucket){
        if(width<=0 || height<=0 || arePerBucket<=0)
            return -1;

        int bucket= (getBucketCount(width*height, arePerBucket));
        return bucket;
    }

    public static int getBucketCount(double area, double arePerBucket){
        if(area<=0 || arePerBucket<=0)
            return -1;

        int bucket= (int) Math.ceil(area/arePerBucket);
        return bucket;
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int count = 0;


        while (true) {
            boolean isInt = scanner.hasNextInt();

            if (isInt) {
                int num = scanner.nextInt();
                sum += num;
                count++;
            } else {
                System.out.println("SUM = " + sum + " AVG = " + Math.round((double) sum / count));
                break;
            }
        }
        scanner.close();
    }

    private static void minMaxValue() {
        Scanner in = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // boolean first = true;

        while (true) {
            System.out.println("Enter the number: ");
            boolean hasNextInt = in.hasNextInt();

            if (hasNextInt) {

                int number = in.nextInt();

//                if (first) {
//                    min = number;
//                    max = number;
//                    first = false;
//                }
                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            } else
                break;
        }

        System.out.println("min = " + min + " max = " + max);
        in.close();
    }

    private static void sumOfTenNumber(int number) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        int sum = 0;

        while (counter < number) {
            int order = counter + 1;
            System.out.println("Enter the number #" + order + ":");

            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int num = scanner.nextInt();
                sum += num;
                counter++;
            } else {
                System.out.println("Invalid Number");
            }
            scanner.nextLine();

        }

        System.out.println("sum of " + number + " number = " + sum);

        scanner.close();
    }
}

