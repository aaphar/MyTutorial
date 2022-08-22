package collections.UnboxingAutoboxing.Exercise;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean newCustomer(String nameOfCustomer, double initialTransaction) {
        Customer existingCustomer = findCustomer(nameOfCustomer);

        if (existingCustomer == null) {
            customers.add(new Customer(nameOfCustomer, initialTransaction));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String nameOfCustomer, double transaction) {
        Customer existingCustomer = findCustomer(nameOfCustomer);

        if (existingCustomer != null) {
            existingCustomer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String nameOfCustomer) {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer checkedCustomer=this.customers.get(i);
            if (checkedCustomer.getName().equals(nameOfCustomer)) {
                return checkedCustomer;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
