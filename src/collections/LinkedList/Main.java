package collections.LinkedList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName()
                + " is " + customer.getBalance());


        ArrayList<Integer> intList=new ArrayList<>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i+ ": "+intList.get(i));
        }

        intList.add(1,2);

        /**
         * lots of works when insert new element
         * because all other elements moved down to make space
         *
         * also when we delete element
         * all other elements moved up to filled that space
         *
         * that is why there is lots of works and it makes
         * program slover
         */

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i+ ": "+intList.get(i));
        }

    }
}