package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberConvertor {
    public static void main(String[] args) {
        System.out.println(zeros(1000));
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
