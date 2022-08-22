package collections.theater.seats;

import java.util.*;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();

    // anonymous inner class
    static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if (seat1.getPrice() < seat2.getPrice()) {
                    return -1;
                } else if (seat1.getPrice() > seat2.getPrice()) {
                    return 1;
                } else {
                    return 0; // not same sit but sit with same price
                }
            }
        };
    }

    public Theater(String theaterName, int numRows, int seatPerRow) {
        this.theaterName = theaterName;

        int lastRow = 'A' + (numRows - 1);  // 'A' and next 7 char
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatPerRow; seatNum++) {

                double price = 12.00;

                if (row < 'D' && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if (row > 'F' || (seatNum < 4 || seatNum > 9)) {
                    price = 7;
                }

                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    public boolean reserveSeat(String seatNumber) {

//        /**
//         * used to check efficiency
//         */
//        int low = 0;
//        int high = seats.size() - 1;
//
//        while (low <= high) {
//            System.out.print(".");
//            int mid = (low + high) / 2;
//            Seat midVal = seats.get(mid);
//            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
//
//            if (cmp < 0) {
//                low = mid + 1;
//            } else if (cmp > 0) {
//                high = mid - 1;
//            } else {
//                return seats.get(mid).reserve();
//            }
//        }
//        System.out.println("There is no seat " + seatNumber);
//        return false;


        Seat requestSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }


//        Seat requestSeat = null;
//
//        for (Seat seat : seats) {
//            System.out.print(".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestSeat = seat;
//                break;
//            }
//        }
//
//        if (requestSeat == null) {
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//
//        return requestSeat.reserve();
    }

    public Collection<Seat> getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat> { // compare 2 seats
        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }
    }
}
