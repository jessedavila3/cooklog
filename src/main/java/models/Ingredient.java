package models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Ingredient {

    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    private double amount;

    @NotNull
    private String typeOfAmount;

    public Ingredient() {

    }

    public Ingredient(String name, double amount, String typeOfAmount) {
        this.name = name;
        this.amount = amount;
        this.typeOfAmount = typeOfAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTypeOfAmount() {
        return typeOfAmount;
    }

    public void setTypeOfAmount(String typeOfAmount) {
        this.typeOfAmount = typeOfAmount;
    }
}