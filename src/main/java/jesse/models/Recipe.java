package jesse.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient> ingredientList;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "step")
//    private List<Step> steps;

    @Column
    private String cuisineType;

    public Recipe() {}

    public Recipe(String name, List<Ingredient> ingredients, String cuisineType) {
        this.name = name;
        this.ingredientList = ingredients;
        this.cuisineType = cuisineType;
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

//    public List<Step> getSteps() {
//        return steps;
//    }

    public String getCuisineType() {
        return cuisineType;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}