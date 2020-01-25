package guru.springframework.services;


import guru.springframework.domain.Recipe;
import guru.springframework.reposirories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


public class RecipeServiceImplTest {
    RecipeService recipeService;

    @Mock
    RecipeRepository repository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(repository);
    }

    @Test
    public void getRecipe() {
        Recipe recipe = new Recipe();
        HashSet<Recipe> recipes = new HashSet<>();
        recipes.add(recipe);
        when(recipeService.getRecipe()).thenReturn(recipes);

        Set<Recipe> recipeSer = recipeService.getRecipe();
        assertEquals(recipeSer.size(), 1);

        verify(repository, times(1)).findAll();
    }
}
