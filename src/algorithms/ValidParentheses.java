package algorithms;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Pattern;

public class ValidParentheses {

    public static void main(String[] args) {

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
}