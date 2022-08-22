package oop.Inheritance;

public class Main{
    public static void main(String[] args) {

        Outlander outlander=new Outlander(36);
        outlander.steer(45);
        outlander.accelerate(30);
        outlander.accelerate(20);
        outlander.accelerate(-50);
    }
}


//public class ComplexNumber {
//    private double real;
//    private double imaginary;
//
//    public ComplexNumber(double real, double imaginary) {
//        this.real = real;
//        this.imaginary = imaginary;
//    }
//
//    public double getReal() {
//        return this.real;
//    }
//
//    public double getImaginary() {
//        return this.imaginary;
//    }
//
//    public void add(double real, double imaginary) {
//        this.real += real;
//        this.imaginary += imaginary;
//    }
//
//    public void add(ComplexNumber complexNumber) {
//        add(complexNumber.getReal(), complexNumber.getImaginary());
//    }
//
//    public void subtract(double real, double imaginary) {
//        this.real -= real;
//        this.imaginary -= imaginary;
//    }
//
//    public void subtract(ComplexNumber complexNumber) {
//        subtract(complexNumber.getReal(), complexNumber.getImaginary());
//    }
//}

//public class Point {
//    private int x;
//    private int y;
//
//    public Point() {
//
//    }
//
//    public Point(int x, int y) {
//        setX(x);
//        setY(y);
//    }
//
//    public int getX() {
//        return this.x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return this.y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public double distance() {
//        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
//    }
//
//    public double distance(int x, int y) {
//        return Math.sqrt(Math.pow(Math.abs(this.x - x), 2) + Math.pow(Math.abs(this.y - y), 2));
//    }
//
//    public double distance(Point point) {
//        return Math.sqrt(Math.pow(this.x - point.getX(), 2) + Math.pow(this.y - point.getY(), 2));
//    }
//}

//public class BankAccount {
//    private String accountNumber;
//    private double balance;
//    private String customerName;
//    private String email;
//    private String phoneNumber;
//
//    public BankAccount(){
//        this("34938", 2.50, "default name", "default address", " default phone");
//        System.out.println("empty constructor called");
//    }
//
//    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber){
//        System.out.println("Account constructor with parameter called");
//        setAccountNumber(accountNumber);
//        this.accountNumber=accountNumber;
//        this.balance=balance;
//        this.customerName=customerName;
//        this.email=email;
//        this.phoneNumber=phoneNumber;
//    }
//
//    public BankAccount(String customerName, String email, String phoneNumber) {
//        this("9999", 100.55, customerName, email, phoneNumber);
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getCustomerName() {
//        return this.customerName;
//    }
//
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public String getAccountNumber() {
//        return this.accountNumber;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public double getBalance() {
//        return this.balance;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getEmail() {
//        return this.email;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getPhoneNumber() {
//        return this.phoneNumber;
//    }
//
//    public void deposit(double amount) {
//        if (amount > 0) {
//            this.balance += amount;
//            System.out.println(amount + " amount money deposited");
//        }
//    }
//
//    public void withdraw(double amount) {
//        if (this.balance - amount < 0) {
//            System.out.println("Only " + this.balance + " can be withdraw");
//        }
//        if (amount > 0) {
//            this.balance -= amount;
//            System.out.println(amount + " amount money withdraw");
//        }
//    }
//}
