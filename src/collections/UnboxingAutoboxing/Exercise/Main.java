package collections.UnboxingAutoboxing.Exercise;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("National Azerbaijan Bank");

        bank.addBranch("Baku");

        bank.addCustomer("Baku", "Aphar", 150.05);
        bank.addCustomer("Baku", "Azad", 174.05);
        bank.addCustomer("Baku", "Zeynab", 50.05);

        bank.addBranch("Ganca");
        bank.addCustomer("Ganca", "Aysun", 44.05);

        bank.addCustomerTransaction("Baku", "Aphar", 45.6);
        bank.addCustomerTransaction("Baku", "Aphar", 75.6);

        bank.listCustomers("Baku", true);
        bank.listCustomers("Ganca", true);

        if(!bank.addCustomerTransaction("Baku", "Jim", 7.3)){
            System.out.println("not exist");
        }
    }
}
