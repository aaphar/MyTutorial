package scops;

import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {

        X x = new X(new Scanner(System.in));
        x.x();

    }
}

class X {
    private int x;

    public X(Scanner x) {
        System.out.println("Please enter a number: ");
        this.x = x.nextInt();
    }

    public void x() {
        for (int x = 1; x < 12; x++) {
            System.out.println(this.x + " times " + x + " is " + this.x * x);
        }
    }
}
