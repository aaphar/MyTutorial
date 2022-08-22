package collections.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class DemoLinkedList {
    public static void main(String[] args) {

        LinkedList<String> placeToVisit = new LinkedList<>();

//        placeToVisit.add("Sydney");
//        placeToVisit.add("Melbourne");
//        placeToVisit.add("Brisbane");
//        placeToVisit.add("Perth");
//        placeToVisit.add("Canberra");
//        placeToVisit.add("Adelaide");
//        placeToVisit.add("Darwin");
//
//        printList(placeToVisit);
//
//        placeToVisit.add(1, "Alice Spring");
//        printList(placeToVisit);
//
//        placeToVisit.remove(4);
//        printList(placeToVisit);


        addInOrder(placeToVisit, "Sydney");
        addInOrder(placeToVisit, "Melbourne");
        addInOrder(placeToVisit, "Brisbane");
        addInOrder(placeToVisit, "Perth");
        addInOrder(placeToVisit, "Canberra");
        addInOrder(placeToVisit, "Adelaide");
        addInOrder(placeToVisit, "Darwin");

        printList(placeToVisit);

        addInOrder(placeToVisit, "Alice Spring");
        addInOrder(placeToVisit, "Darwin");

        printList(placeToVisit);

        visit(placeToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();

        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("====================================");
    }

    /**
     * add cities in alphabetical order
     *
     * @param linkedList
     * @param newCity
     * @return true if city added, false if city is already exists
     */
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {

        //normal iterator don't go back, just go forward
        //ListIterator is special type iterator, can go back and forward
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);

            if (comparison == 0) {
                //index is equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                //newCity should appear before this one
                //Brisbane -> Adelaide(newCity) : alphabetic order A before B
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                //move on next city
                //Adelaide -> Brisbane : alphabetic order B after A
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true; //no current action exists
        ListIterator<String> listIterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {

                case 1:
                    //if user previously selected goingBackward
                    //and we currently not going backward
                    // we need to go forward
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    //if user previously selected goingForward
                    //and we currently not going Forward
                    // we need to go backward
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the starting of the list");
                        goingForward = true;//only direction we can go at the beginning
                    }
                    break;
                case 3:
                    printMenu();
                    break;
                default:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions: \npress ");
        System.out.println("1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options" +
                "Any Number - to quit\n");
    }
}

