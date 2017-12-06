package controllers;

import models.Ingredient;
import models.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @GetMapping("/")
    public String showIndex() {
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
    public String showIngredientForm(Ingredient ingredient) {
        return "ingredient-form";
    }

    @PostMapping("/ingredient")
    public String checkAndSubmitIngredient(@Valid Ingredient ingredient,
                                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "ingredient-form";
        }

        return "redirect:/recipe";
    }


}
