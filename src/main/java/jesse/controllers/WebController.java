package jesse.controllers;

import jesse.models.Ingredient;
import jesse.models.Recipe;
import jesse.repositories.IngredientRepository;
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

    public WebController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/")
    public String showIndex() {
        System.out.println("hello world");
        return "index";
    }
    @GetMapping("/recipe")
    public String showForm(Recipe recipe) {
        return "recipe-form";
    }

    @PostMapping("/recipe")
    public String checkAndSubmitRecipe(@Valid Recipe recipe,
                                       BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "recipe-form";
        }

        return "redirect:/index";
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


}
