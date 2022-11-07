package algorithms;

import java.util.*;

class Test<T> {
    T obj;

    Test(T obj) {
        this.obj = obj;
    }

    public T getObject() {
        return this.obj;
    }
}

class Main {
    public static void main(String[] args) {
        Object iObj = 19;
        System.out.println(iObj.toString());
        iObj = "Runtime error";
        System.out.println(iObj.toString());

        Object sObj = ("String object");
        System.out.println(sObj.toString());
        sObj = (1);
        System.out.println(sObj.toString());
    }

    // hackRank
    public static void countSort(List<List<String>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {

            }
        }

    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        List<Integer> list = new ArrayList<>(arr);
        for (int i = 0; i < arr.size(); i++) {
            if (i < d) {
                list.set(arr.size() - d + i, arr.get(i));
            } else {
                list.set(i - d, arr.get(i));
            }
        }
        return list;
    }


    public static void miniMaxSum(List<Integer> arr) {
        long minSum = 0;
        long maxSum = 0;
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            if (i < 4) {
                minSum += arr.get(i);
            }
            if (i > 0 && i >= arr.size() - 4) {
                maxSum += arr.get(i);
            }
        }
        System.out.println(minSum + " " + maxSum);
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int tallest = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 0; i < candles.size(); i++) {
            if (candles.get(i) > tallest) {
                tallest = candles.get(i);
            } else if (candles.get(i) == tallest) {
                count++;
            }
        }
        return count;
    }

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        List<Integer> counts = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < queries.size(); i++) {
            for (int j = 0; j < stringList.size(); j++) {
                if (queries.get(i).equals(stringList.get(j))) {
                    count++;
                    counts.add(i, count);
                }
            }
            count = 0;
        }
        return counts;
    }


    public static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - i - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < arr.size(); i++) {
            sum1 += arr.get(i).get(i);
            sum2 += arr.get(i).get(arr.get(i).size() - 1 - i);
        }

        return (sum1 - sum2);
    }

    public static void plusMinus(List<Integer> arr) {
        double minus = 0;
        double zero = 0;
        double plus = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                plus++;
            } else if (arr.get(i) == 0) {
                zero++;
            } else {
                minus++;
            }
        }

        System.out.println(plus / arr.size());
        System.out.println(minus / arr.size());
        System.out.println(zero / arr.size());

    }


    // 5 kyu
    public static boolean allAlone(char[][] house) {
        boolean POTUS = false;
        boolean elves = false;
        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < house[i].length; j++) {
                if (house[i][j] == 'X') {
                    POTUS = true;
                }
                if (house[i][j] == 'o') {
                    elves = true;
                }
            }
        }
        return elves;
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> list = new ArrayList();
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                aCount++;
            } else if (a.get(i) < b.get(i)) {
                bCount++;
            }
        }

        list.add(aCount);
        list.add(bCount);

        return list;
    }

    // 5 kyu
    public static long[] smallest(long n) {
        String num = String.valueOf(n);
        String[] digits = num.split("");
        String first = digits[0];
        String min = "";
        int minIndex = 0;

        for (int i = 0; i < digits.length - 1; i++) {
            if (Long.parseLong(digits[i]) > Long.parseLong(digits[i + 1])) {
                min = digits[i + 1];
                minIndex = i + 1;
            }
        }

        digits[0] = min;
        digits[minIndex] = first;

        long[] result = new long[digits.length];

        for (int i = 0; i < digits.length; i++) {
            result[i] = Long.parseLong(digits[i]);
        }

        return result;
    }
}
