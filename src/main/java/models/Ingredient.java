package models;

public class Ingredient {

    private String name;
    private double amount;
    private String typeOfAmount;

    public Ingredient(String name, double amount, String typeOfAmount) {
        this.name = name;
        this.amount = amount;
        this.typeOfAmount = typeOfAmount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getTypeOfAmount() {
        return typeOfAmount;
    }
}