package jesse.controllers;

import jesse.models.Ingredient;
import jesse.models.Recipe;
import jesse.repositories.IngredientRepository;
import jesse.repositories.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;

    public WebController(IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        return "index";
    }
    @GetMapping("/recipe")
    public String showForm(Recipe recipe, Model model) {
        Iterable<Ingredient> allIngredients = ingredientRepository.findAll();
        model.addAttribute("ingredients", allIngredients);
        return "recipe-form";
    }

    @GetMapping("/allIngredients")
    public String showAllIngredients(Model model) {
        Iterable<Ingredient> allIngredients = ingredientRepository.findAll();
        model.addAttribute("ingredients", allIngredients);
        return "allIngredientList";
    }

    @GetMapping("/ingredient")
    public String showIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredient-form";
    }

    @PostMapping("/ingredient")
    public String checkAndSubmitIngredient(@Valid @ModelAttribute Ingredient ingredient,
                                           BindingResult bindingResult,
                                           @RequestParam(name = "name") String name,
                                           @RequestParam(name = "amount") double amount,
                                           @RequestParam(name = "typeOfAmount") String typeOfAmount) {

        if (bindingResult.hasErrors()) {
            return "ingredient-form";
        }
        ingredient.setName(name);
        ingredient.setAmount(amount);
        ingredient.setTypeOfAmount(typeOfAmount);
        ingredientRepository.save(ingredient);

        return "redirect:/recipe";
    }

    @PostMapping("/recipe")
    public String checkAndSubmitRecipe(@Valid @ModelAttribute Recipe recipe,
                                       BindingResult bindingResult,
                                       @RequestParam(name = "name") String name,
                                       @RequestParam(name = "cuisineType") String cuisineType,
                                       @RequestParam(name = "ingredients.id") Iterable<Long> ids) {

        if (bindingResult.hasErrors()) {
            return "recipe-form";
        }
        System.out.println(ids);
        recipe.setName(name);
        recipe.setCuisineType(cuisineType);
        recipeRepository.save(recipe);

        return "redirect:/";
    }

    private Iterable<Long> findSelectedIngredients() {
        // take all active checkboxes and return their id's in a list.
        return null;
    }

}
