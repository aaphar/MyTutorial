package algorithms;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidParentheses {
    public static void main(String[] args) {
//        System.out.println(isBalanced("{}(), ({()}), {}("));
//        System.out.println(decryptMessage("aferdir adi2m menim"));

        Scanner scanner = new Scanner(System.in);
        String word[] = scanner.nextLine().split("");
        int lastIndex = word.length - 1;
        boolean palindrom = false;

        for (int i = 0; i < word.length; i++) {
            if (word[i].equals(word[lastIndex - i])) {
                palindrom = true;
            } else {
                palindrom = false;
                break;
            }
        }

        if(palindrom){
            System.out.println("Yes");
        }

    }

    // HackRank exercise
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

    // 5 kyu
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