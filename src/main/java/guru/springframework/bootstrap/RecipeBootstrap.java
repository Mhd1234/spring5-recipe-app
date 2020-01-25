package guru.springframework.bootstrap;


import guru.springframework.domain.*;
import guru.springframework.reposirories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final RecipeRepository recipeRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    private Set<Recipe> getListRecipes(){
        Recipe recipe = new Recipe();

//        Category category = new Category();
//        category.setDescription("Simple descr");
//
////        Set<Category> categories = new HashSet<>();
////        categories.add(category);
//        //recipe.setCategories(categories);
//        Set<Recipe> recipes = new HashSet<>();
//        recipes.add(recipe);
//        category.setRecipes(recipes);
//        Set<Category> categories= new HashSet<>();
//        categories.add(category);
//        recipe.setCategories(categories);
        recipe.setCookTime(1000);
        recipe.setDescription("Simpele recept");
        recipe.setDifficulty(Difficulty.EASY);
        System.out.println(recipe);
//        Notes notes = new Notes();
//        notes.setRecipe(recipe);
//        notes.setRecipeNotes("Simppe node recipe NOTE");
//        recipe.setNotes(notes);
//
//        Ingredient ingredient = new Ingredient();
//        ingredient.setAmount(new BigDecimal(1111));
//
//
//        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
//        unitOfMeasure.setUom("dsadsa");
//        ingredient.setUnitOfMeasure(unitOfMeasure);
//        recipe.addIngredient(ingredient);


        return new HashSet<>(Arrays.asList(recipe));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("onApplicationEvent. Loading");
        getListRecipes();
    }
}
