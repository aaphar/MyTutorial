package oop.NestedClass;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        //static nested classes
        //nonstatic nested classes - inner class
        //local class - inner class inside scope block
        //anonymous class - nested class without class name

//        Gearbox mcLauren = new Gearbox(6);
//
//        mcLauren.operateClutch(true);
//        mcLauren.changeGear(1);
//        mcLauren.operateClutch(false);
//        System.out.println(mcLauren.wheelSpeed(1000));
//        mcLauren.changeGear(2);
//        System.out.println(mcLauren.wheelSpeed(1000));
//        mcLauren.operateClutch(true);
//        mcLauren.changeGear(3);
//        mcLauren.operateClutch(false);
//        System.out.println(mcLauren.wheelSpeed(6000));


        /**
         * local class - if you want to assign exactly same object(example same buttons)
         * on the screen at the same time class is not used anywhere,
         * so making it local make sense.
         */
//        class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println("I have been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked");
//            }
//        }

//        btnPrint.setOnClickListener(new ClickListener());

        /**
         * anonymous class - no name
         */
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title+ "was clicked");
            }
        });
        listen();

    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
                    break;
            }
        }
    }
}
