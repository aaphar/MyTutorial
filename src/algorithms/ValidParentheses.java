package algorithms;

import java.math.BigInteger;
import java.util.Arrays;

public class ValidParentheses {
    public static void main(String[] args) {
        validParentheses("\\5W)n)>7(q4L0JU(a)Rz(ujKty");
        System.out.println(IsPrime(3));
        System.out.println(spinWords("Hey fellow warriors"));

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

    public static boolean validParentheses(String parens) {
        String[] arr = parens.split("");
        int counter = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")) {
                counter--;
            }
            if (arr[i].equals(")")) {
                counter++;
                if (counter > arr.length) {
                    return false;
                }
            }
        }
        return counter == arr.length;
    }

    public static int getCount(String str) {
        String[] character = str.split("");
        int count = 0;
        for (String s : character) {
            switch (s) {
                case "a", "e", "i", "o", "u" -> count++;
            }
        }
        return count;
    }

    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {

            if (words[i].length() >= 5) {
                String[] letters = (words[i].split(""));
                StringBuilder newWord = new StringBuilder();
                for (int j = words[i].length() - 1; j >= 0; j--) {
                    newWord.append(letters[j]);
                }
                words[i] = newWord.toString();
            }
        }
        return Arrays.toString(words).replace("[", "")
                .replace("]", "")
                .replace(",", "");
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