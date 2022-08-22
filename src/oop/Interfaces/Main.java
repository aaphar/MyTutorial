package oop.Interfaces;

public class Main {
    public static void main(String[] args) {
        ITelephone phone; //cannot instantiate with interface
        phone = new DeskPhone(3894394);
        phone.powerOn();
        phone.callPhone(3894394);
        phone.answer();

        System.out.println();

        phone=new MobilePhone(98768);
        phone.powerOn();
        phone.callPhone(98768);
        phone.answer();
    }
}
