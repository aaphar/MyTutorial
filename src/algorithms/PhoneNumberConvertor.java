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

    // 5 kyu
    public static int zeros(int n) {
        int zero = 0;
        if (n >= 5) {
            for (int i = 1; i < Math.sqrt(n); i++) {
                zero += (n / Math.pow(5, i));
            }
        }
        return zero;
    }

    // 5 kyu
    public static String rgb(int r, int g, int b) {
        String red = "";
        String green = "";
        String blue = "";

        if (r >= 0 && r <= 255) {
            red = (Integer.toHexString(r).length() < 2) ? ("0" + Integer.toHexString(r)) : (Integer.toHexString(r));
        } else if (r < 0) {
            red = "00";
//            g = (g < 200) ? g : 255;
        } else {
            red = "FF";
        }

        if (g >= 0 && g <= 255) {
            green = (Integer.toHexString(g).length() < 2) ? ("0" + Integer.toHexString(g)) : (Integer.toHexString(g));
        } else if (g < 0) {
            green = "00";
//            b = (b < 200) ? b : 255;
        } else {
            green = "FF";
        }

        if (b >= 0 && b <= 255) {
            blue = (Integer.toHexString(b).length() < 2) ? ("0" + Integer.toHexString(b)) : (Integer.toHexString(b));
        } else if (b < 0) {
            blue = "00";
        } else {
            blue = "FF";
        }

        return red.toUpperCase() + green.toUpperCase() + blue.toUpperCase();
    }

    // 5 kyu
    public static boolean scramble(String str1, String str2) {
        Map<Character, Integer> word1 = countLetters(str1);
        Map<Character, Integer> word2 = countLetters(str2);

        for (Character c : word2.keySet()) {
            Integer n = word1.get(c);
            if (n == null || n < word2.get(c)) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> countLetters(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            Integer n = map.get(c);
            if (n == null) {
                map.put(c, 1);
            } else {
                map.put(c, n + 1);
            }
        }
        return map;
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

    //6 kyu
    public static int[] sumParts(int[] ls) {
        int[] sum = new int[ls.length + 1]; //7leng
        sum[sum.length - 1] = 0; //index 6
        for (int i = ls.length - 1; i >= 0; i--) { // index 5
            sum[i] = sum[i + 1] + ls[i];
        }

        return sum;
    }

    // 6kyu
    public static String camelCase(String input) {
        String[] inputArr = input.split("");
        String newWord = "";

        if (inputArr.length > 0 && !input.isBlank()) {
            for (String s : inputArr) {
                if (s.toUpperCase().equals(s)) {
                    newWord += " ";
                }
                newWord += s;
            }
        }
        return newWord;
    }

    // 6 kyu
    public static String createPhoneNumber(int[] numbers) {
        String s = "(";
        for (int i = 0; i < numbers.length; i++) {
            if (i <= 2) {
                s += numbers[i];
                if (i == 2) {
                    s += ") ";
                }
            } else if (i <= 5) {
                s += numbers[i];
                if (i == 5) {
                    s += "-";
                }
            } else if (i <= 9) {
                s += numbers[i];
            }
        }
        return s;
    }
}
