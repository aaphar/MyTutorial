package algorithms;

public class PhoneNumberConvertor {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(createPhoneNumber(arr));

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
