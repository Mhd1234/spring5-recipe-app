package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.reposirories.RecipeRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipe() {
        log.debug("I'am service");
        Set<Recipe> recipes = new HashSet<>();


        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }
}
