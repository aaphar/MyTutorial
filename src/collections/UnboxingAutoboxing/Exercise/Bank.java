package collections.UnboxingAutoboxing.Exercise;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String nameOfBranch) {
        Branch existingBranch = findBranch(nameOfBranch);

        if (existingBranch == null) {
            this.branches.add(new Branch(nameOfBranch));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String nameOfBranch, String nameOfCustomer, double initialTransaction) {
        Branch existingBranch = findBranch(nameOfBranch);

        if (existingBranch != null) {
            return existingBranch.newCustomer(nameOfCustomer, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transaction) {
        Branch existingBranch = findBranch(nameOfBranch);

        if (existingBranch != null) {
            return existingBranch.addCustomerTransaction(nameOfCustomer, transaction);
        }
        return false;
    }

    private Branch findBranch(String nameOfBranch) {
        for (int i = 0; i < branches.size(); i++) {

            Branch checkedBranch = this.branches.get(i);

            if (checkedBranch.getName().equals(nameOfBranch)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String nameOfBranch, boolean printTransaction) {
        Branch existingBranch = findBranch(nameOfBranch);

        if (existingBranch != null) {

            System.out.println("Customer details for branch " + existingBranch.getName());

            ArrayList<Customer> customers = existingBranch.getCustomers();

            for (int i = 0; i < customers.size(); i++) {

                Customer customer = customers.get(i);
                System.out.println("Customer: " + customer.getName() + "[" + (i + 1) + "]");

                ArrayList<Double> transactions = customer.getTransactions();

                if (printTransaction) {
                    System.out.println("Transactions\n");

                    for (int j = 0; j < transactions.size();
                         j++) {
                        double transaction = transactions.get(j);
                        System.out.println("[" + (j + 1) + "]  Amount " + transaction);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
