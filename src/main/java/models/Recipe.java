package models;

public class Recipe {

    private String name;
    private Ingredient[] ingredients;
    private Step[] steps;
    private String cuisineType;

    public Recipe(String name, Ingredient[] ingredients, Step[] steps, String cuisineType) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.cuisineType = cuisineType;
    }

    public String getName() {
        return name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public Step[] getSteps() {
        return steps;
    }

    public String getCuisineType() {
        return cuisineType;
    }
}