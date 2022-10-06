package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberConvertor {
    public static void main(String[] args) {

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
            } else if (i >= 3 && i <= 5) {
                s += numbers[i];
                if (i == 5) {
                    s += "-";
                }
            } else if (i >= 6 && i <= 9) {
                s += numbers[i];
            }
        }
        return s;
    }
}
