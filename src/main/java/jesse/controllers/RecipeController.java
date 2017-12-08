package jesse.controllers;

import jesse.models.Ingredient;
import jesse.models.Recipe;
import jesse.models.Step;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    public Ingredient water = new Ingredient("water",12,"oz");
    public Ingredient flour = new Ingredient("bread flour",500,"grams");
    public Step firstStep = new Step("Mix together");
    public Step secondStep = new Step("Let ferment 12 hours");
    public Ingredient[] ingredients = {water, flour};
    public Step[] steps = {firstStep, secondStep};

    @RequestMapping("/ingredient-test")
    public Ingredient ingredient(@RequestParam(value="name", defaultValue = "water") String name) {
        return new Ingredient(name, 12,"oz");
    }

    @RequestMapping("/recipe-test")
    public Recipe makeBread() {
        return new Recipe("bread",ingredients,steps,"Global");
    }
}
