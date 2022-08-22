package keywords.statics;

public class Main {

    public static int multiplier = 7;

    public static void main(String[] args) {
//        StaticTest firstInstance = new StaticTest("1st Instance");
//        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstance());
//
//        StaticTest secondInstance=new StaticTest("2nd Instance");
//        System.out.println(secondInstance.getName()+ " is instance number "+ StaticTest.getNumInstance());
//
//        StaticTest thirdInstance=new StaticTest("3rd Instance");
//        System.out.println(thirdInstance.getName()+ " is instance number "+ StaticTest.getNumInstance());

        // java com.company._static.Main - can run from command line

        int answer = multiply(6);
        System.out.println("The answer is " + answer);
        System.out.println("Multiply is " + multiplier);

        // main is static that is why it cannot access non-static field and methods

    }

    public static int multiply(int number) {
        return number * multiplier;
    }
}
