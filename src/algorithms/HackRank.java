package algorithms;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Pattern;

public class HackRank {
    static int R = 6;
    static int C = 6;

    // Return maximum sum of
    // hour glass in ar[][]
    public static int hourglassSum(int[][] mat) {
        if (R < 3 || C < 3) {
            System.out.println("Not possible");
            System.exit(0);
        }

        // Here loop runs (R-3)*(C-3)
        // times considering different
        // top left cells of hour glasses.
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < R - 2; i++) { // yeni hemise sogda start pointden elave iki olmalidir
            for (int j = 0; j < C - 2; j++) {
                // Considering mat[i][j] as top
                // left cell of hour glass.
                int sum = (mat[i][j] + mat[i][j + 1] + mat[i][j + 2]) +
                        (mat[i + 1][j + 1]) +
                        (mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2]);

                // If previous sum is less than
                // current sum then update
                // new sum in max_sum
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        if (R < 3 || C < 3) {
            System.out.println("Not possible");
            System.exit(0);
        }

        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {

                int sum = (arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)) +
                        (arr.get(i + 1).get(j + 1)) +
                        (arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2));

                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    // HackRank exercise
    public static long countPairs(List<Integer> arr) {
        // Write your code here
        long ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                long and = arr.get(i) & arr.get(j);
                if ((and & (and - 1)) == 0 && and != 0)
                    ans++;
            }
        }
        return ans;
    }

    // Intermediate test
    public static int sortedSum(List<Integer> a) {
        LinkedList<Integer> newList = new LinkedList<>();
        int totalSum = 0;
        for (int i = 0; i < a.size(); i++) {
            newList.add(a.get(i));
            Collections.sort(newList);
            System.out.println(newList);
            for (int j = 0; j < newList.size(); j++) {
                totalSum += newList.get(j) * (j + 1);
            }
        }
        return totalSum;
    }

    public static void CurrencyProblem() {
        Locale INDIA = new Locale("en", "IN", "Rs.");

        Scanner scanner = new Scanner(System.in);
        double currency = scanner.nextDouble();
        scanner.close();

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("US: " + nf.format(currency));

        nf = NumberFormat.getCurrencyInstance(INDIA);
        System.out.println("India: " + nf.format(currency));

        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("China: " + nf.format(currency));

        nf = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        System.out.println("France: " + nf.format(currency));
    }

    public static String findSubstring(String s, int k) {
        // Write your code here
        int max = 0;
        String slice = "";
        String main = "";
        for (int i = 0; i <= s.length() - k; i++) {
            int vovel = 0;
            slice = s.substring(i, i + k);
            char[] letters = slice.toCharArray();
            for (char letter : letters) {
                if (letter == 'a' || letter == 'e' ||
                        letter == 'i' || letter == 'o' || letter == 'u') {
                    vovel++;
                }
            }
            if (vovel > max) {
                max = vovel;
                main = slice;
            }
        }
        if (max == 0) {
            return "Not found!";
        }
        return main;
    }


    //Find week of day
    public static String findDay(int month, int day, int year) {
        Date date = new GregorianCalendar(year, month - 1, day).getTime();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        String dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.forLanguageTag("en"));

        return dayOfWeek.toUpperCase();
    }

    public static String decryptMessage(String encryptedMessage) {
        String[] messageArr = encryptedMessage.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = messageArr.length - 1; i >= 0; i--) {
            String[] word = messageArr[i].split("");
            for (int j = 0; j < word.length; j++) {
                Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
                if (pattern.matcher(word[j]).matches()) {
                    int count = Integer.parseInt(word[j]) - 1;
                    while (count > 0) {
                        word[j + count - 1] = word[j - 1];
                        count--;
                    }
                }
                result.append(word[j]);
            }
            result.append(" ");
        }

        return result.toString();
    }

    public static String isBalanced(String s) {
        String[] arr = s.split(",");
        String result = "";

        for (int i = 0; i < arr.length; i++) {
            String[] partOne = arr[i].split("");

            int counterCurly = partOne.length;
            int counter = partOne.length;

            for (int j = 0; j < partOne.length; j++) {
                if (partOne[j].equals("{")) {
                    counterCurly++;
                }
                if (partOne[j].equals("}")) {
                    counterCurly--;
                }

                if (partOne[j].equals("(")) {
                    counter++;
                }
                if (partOne[j].equals(")")) {
                    counter--;
                }
            }


            if (counterCurly == arr[i].length() && counter == arr[i].length()) {
                result += "\ntrue";
            } else {
                result += "\nfalse";
            }
        }
        return result;
    }

    public static int GetLastDigit(BigInteger n1, BigInteger n2) {
        switch ((n1.intValue()) % 10) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                if (n2.intValue() > 4) {
                    switch (n2.intValue() % 4) {
                        case 0:
                        case 4:
                            return 1;
                        case 1:
                            return 7;
                        case 2:
                            return 9;
                        case 3:
                            return 3;
                    }
                }
        }

        Double result = Math.pow(n1.doubleValue(), n2.doubleValue());
        double num = result % 10;
        return (int) num;
    }

    public static boolean IsPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        for (int i = 0; i < d; i++) {
            int element = a.remove(0);
            a.add(element);
        }
        return a;
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
}
