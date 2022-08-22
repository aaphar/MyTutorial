package academy.learnprogramming;

public class Main {
    public static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        System.out.println("The sum of the digits in number 125 is "
                + sumDigits(125));

        System.out.println(isPalindrome(11));
        System.out.println(getGreatestCommonDivisor(15, 30));
        System.out.println(getDigitCount(124));
        numberToWords(100);
        System.out.println();
        numberToWords(0);
        System.out.println(reverse(-2));
        System.out.println(reverse(0));
        System.out.println(getDigitCount(0));

        System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(7));
        System.out.println();
        printSquareStar(2);

        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(-3945));

    }


    public static boolean canPack(int bigCount, int smallCount, int goal) {

        if (bigCount < 0 || smallCount < 0 || goal < 0)
            return false;

        for (int i = 0; i <= bigCount; i++) {
            for (int j = 0; j <= smallCount; j++) {
                if ((5 * i) + j == goal)
                    return true;
            }
        }
        return false;
    }

    public static int getLargestPrime(int number) {
        if (number < 2)
            return -1;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                number /= i;
                i--;
            }
        }
        return number;
    }

    public static void printSquareStar(int number) {
        if (number < 5)
            System.out.println("Invalid Value");
        else {
            for (int row = 1; row <= number; row++) {
                for (int column = 1; column <= number; column++) {
                    if (row == 1 || row == number)
                        System.out.print("*");
                    else if (column == 1 || column == number)
                        System.out.print("*");
                    else if (row == column)
                        System.out.print("*");
                    else if (column == number - row + 1)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    public static void numberToWords(int number) {

        if (number < 0)
            System.out.println("Invalid Value");
        //1=100
        int reverseNumber = reverse(number);

        for (int i = 0; i < getDigitCount(number); i++) {
            //1%10=1; 0%10=0; 0%10=0
            switch (reverseNumber % 10) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
            }
            reverseNumber /= 10;
        }
    }


    public static int reverse(int number) {
        int reverse = 0;

        while (number != 0) {
            reverse = (reverse * 10) + (number % 10);
            number /= 10;
        }
        return reverse;
    }

    public static int getDigitCount(int number) {
        int count = 1;

        if (number < 0)
            return -1;

        while (number > 9) {
            count++;
            number /= 10;
        }

        return count;
    }

    public static boolean isPerfectNumber(int number) {
        int divisors = 0;

        if (number < 1)
            return false;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0)
                divisors += i;
        }

        return divisors == number;
    }

    public static void printFactor(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
        } else {
            for (int i = 1; i <= number; i++) {
                if (number % i == 0)
                    System.out.println(i + " ");
            }
        }
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        int divisor = first;

        if (first >= 10 && second >= 10) {
            for (int i = divisor; i >= 2; i--) {
                if (first % i == 0 && second % i == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3) {

        if (isValid(num1) && isValid(num2) && isValid(num3)) {

            if (num1 % 10 == num2 % 10 ||
                    num1 % 10 == num3 % 10 ||
                    num2 % 10 == num3 % 10)
                return true;
        }

        return false;
    }

    public static boolean isValid(int number) {
        if (number >= 10 && number <= 1000)
            return true;
        return false;
    }

    public static boolean hasSharedDigit(int num1, int num2) {
        if (num1 >= 10 && num1 <= 99 && num2 >= 10 && num2 <= 99) {
            for (int i = num1; i > 0; i /= 10) {
                for (int j = num2; j > 0; j /= 10) {
                    if (i % 10 == j % 10)
                        return true;
                }
            }
        }
        return false;
    }

    public static int getEvenDigitSum(int number) {
        int sum = 0;

        if (number < 0)
            return -1;

        for (int i = number; i > 0; i /= 10) {
            int digit = i % 10;
            if (digit % 2 == 0)
                sum += digit;
        }
        return sum;
    }

    public static int sumFirstAndLastDigit(int number) {
        int lastDigit = number % 10;
        int firstDigit = 0;

        if (number < 0)
            return -1;
        else {
            while (number > 0) {
                if (number < 10) {
                    firstDigit = number;
                }
                number /= 10;
            }
        }
        return firstDigit + lastDigit;
    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        number = Math.abs(number);

        int temp = number;

        while (number != 0) {
            int lastDigit = number % 10;
            reverse += lastDigit;
            number /= 10;
            if (number != 0) {
                reverse *= 10;
            }
        }

        return reverse == temp;
    }

    private static int sumDigits(int number) {

        if (number < 10) {
            return -1;
        }

        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number /= 10;
        }
        return sum;
    }

    private static String getDurationString(long minutes, long seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59) {
            return INVALID_VALUE_MESSAGE;
        }
        long hour = minutes / 60;
        long minuteRemainder = minutes % 60;

        String hoursString = hour + " h";
        if (hour < 10) {
            hoursString = "0" + hoursString;
        }

        String minutesString = minuteRemainder + " h";
        if (minuteRemainder < 10) {
            minutesString = "0" + minutesString;
        }

        String secondString = seconds + " h";
        if (seconds < 10) {
            secondString = "0" + secondString;
        }

        return hoursString + " " + minutesString + " " + secondString;
    }

    public static String getDurationString(long seconds) {
        if (seconds < 0)
            return INVALID_VALUE_MESSAGE;

        long minute = seconds / 60;
        long secondRemainder = seconds % 60;

        return getDurationString(minute, secondRemainder);
    }

}