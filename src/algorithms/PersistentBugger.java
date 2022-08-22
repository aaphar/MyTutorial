package algorithms;

public class PersistentBugger {
    public static void main(String[] args) {
        System.out.println(persistence(999));

    }

    public static int persistence(long n) {
        int count = 0;
        long remainder;
        while (n >= 10) {
            long multiply = 1;
            while (n >= 1) {
                remainder = n % 10;
                multiply = multiply * remainder;
                n /= 10;
            }
            n = multiply;
            count++;
        }
        return count;
    }
}
