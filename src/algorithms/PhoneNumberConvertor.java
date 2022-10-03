package algorithms;

public class PhoneNumberConvertor {
    public static void main(String[] args) {

    }

    public static int[] sumParts(int[] ls) {
        int[] sum = new int[ls.length + 1]; //7leng
        sum[sum.length - 1] = 0; //index 6
        for (int i = ls.length - 1; i >= 0; i--) { // index 5
            sum[i] = sum[i + 1] + ls[i];
        }

        return sum;
    }

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
