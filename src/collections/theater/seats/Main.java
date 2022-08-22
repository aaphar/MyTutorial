package collections.theater.seats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theater theater = new Theater("Olympian", 8, 12);

//        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats);
//        printList(seatCopy);
//
//        // 2 separate seat but share same data, both reference same object
//        seatCopy.get(1).reserve(); // reserve seat in seatCopy


        if (theater.reserveSeat("D12")) { // check for theater
            System.out.println("Please pay for seat");
        } else {
            System.out.println("Seat already reserved");
        }

        if (theater.reserveSeat("D12")) { // check for theater
            System.out.println("Please pay for seat");
        } else {
            System.out.println("Seat already reserved");
        }

        if (theater.reserveSeat("B12")) { // check for theater
            System.out.println("Please pay for seat");
        } else {
            System.out.println("Seat already reserved");
        }

        List<Theater.Seat> reverseSeat = new ArrayList<>(theater.getSeats());
        Collections.reverse(reverseSeat);
        printList(reverseSeat);


        List<Theater.Seat> priceSeats = new ArrayList<>(theater.getSeats()); // we get copy of our elements
        priceSeats.add(theater.new Seat("B00", 13.00));
        priceSeats.add(theater.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theater.PRICE_ORDER);
        printList(priceSeats);


//        Collections.reverse(seatCopy); // for reverse order
//        Collections.shuffle(seatCopy); // for random order
//        System.out.println("Printing seatCopy");
//        printList(seatCopy);
//        System.out.println("Printing theater.seat");
//        printList(theater.seats);
//
//        // this work even list hasn't been sorted
//        Theater.Seat minSeat = Collections.min(seatCopy);
//        Theater.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println("Min seat number is " + minSeat.getSeatNumber());
//        System.out.println("Max seat number is " + maxSeat.getSeatNumber());
//
//
//        sortList(seatCopy);
//        System.out.println("Printing sorted seatCopy");
//        printList(seatCopy);

//        // only sets the capacity of arraylist, initially contains none
//        List<Theater.Seat> newList = new ArrayList<>(theater.seats.size());
//        Collections.copy(newList, theater.seats);


//            theater.getSeats();

//        if (theater.reserveSeat("b30")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry, seat is taken");
//        }
//
//        if (theater.reserveSeat("H11")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry, seat is taken");
//        }

    }

    public static void printList(List<Theater.Seat> list) {
        for (Theater.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
        System.out.println("=========================================");
    }

//    public static void sortList(List<? extends Theater.Seat> list) {
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (list.get(i).compareTo(list.get(j)) > 0) {
//                    Collections.swap(list, i, j);
//                }
//            }
//        }
//    }

}
