package oop.Composition;

public class Motherboard {
    private String model;
    private String manufacturer;
    private int ramSlot;
    private int cardSlot;
    private String bios;

    public Motherboard(String model, String manufacturer, int ramSlot, int cardSlot, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSlot = ramSlot;
        this.cardSlot = cardSlot;
        this.bios = bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Program " + programName +
                " is now loading...");
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRamSlot() {
        return ramSlot;
    }

    public int getCardSlot() {
        return cardSlot;
    }

    public String getBios() {
        return bios;
    }
}
