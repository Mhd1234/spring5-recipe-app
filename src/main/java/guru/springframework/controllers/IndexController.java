package guru.springframework.controllers;


import guru.springframework.domain.Category;
import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Optional;

@Controller
public class IndexController {


    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = {"/", "", "/index"})
    public String getIndexPage(Model model){
        recipeService.getRecipe();
        HashSet<Recipe> recipes= new HashSet<>();
        model.addAttribute("recipe", recipes);

        return "index";
    }
}
