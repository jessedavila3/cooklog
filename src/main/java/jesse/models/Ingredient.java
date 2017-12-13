package jesse.models;

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private double amount;

    @Column
    private String typeOfAmount;

    @ManyToOne
    @JoinColumn
    private Recipe recipe;

    public Ingredient() {}

    public Ingredient(String name, double amount, String typeOfAmount) {
        this.name = name;
        this.amount = amount;
        this.typeOfAmount = typeOfAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}