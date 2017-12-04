package models;

public class Recipe {

    private Ingredient[] ingredients;
    private Step[] steps;

    public Recipe(Ingredient[] ingredients, Step[] steps) {
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public Step[] getSteps() {
        return steps;
    }
}