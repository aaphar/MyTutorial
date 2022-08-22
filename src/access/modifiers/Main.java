package access.modifiers;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("name");
        account.deposit(1000);
        account.withdraw(500);
        account.withdraw(-200);
        account.deposit(-20);
        account.calculateBalance();
//        account.balance = 5000; // if we set access modifier public

        System.out.println("Balance on account is " + account.getBalance());
//        account.transactions.add(389);
        account.calculateBalance();
    }
}
