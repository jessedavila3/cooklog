package jesse.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Recipe {

    @NotNull
    @Size(min=2, max = 30)
    private String name;

    private Ingredient[] ingredients;

    private Step[] steps;

    private String cuisineType;

    public Recipe() {}

    public Recipe(String name, Ingredient[] ingredients, Step[] steps, String cuisineType) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.cuisineType = cuisineType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredientArray(int amountOfIngredients) {
        this.ingredients = new Ingredient[amountOfIngredients];
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public Step[] getSteps() {
        return steps;
    }

    public String getCuisineType() {
        return cuisineType;
    }
}