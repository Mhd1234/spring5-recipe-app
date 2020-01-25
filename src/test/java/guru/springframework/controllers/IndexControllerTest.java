package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.reposirories.RecipeRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class IndexControllerTest {


    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));

    }

    @Test
    public void getIndexPage() {

        //given
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(new Recipe());
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipeSet.add(recipe);

        when(recipeService.getRecipe()).thenReturn(recipeSet);
        ArgumentCaptor<Set<Recipe>>argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //when
        String res = indexController.getIndexPage(model);

        //then
        assertEquals(res, "index");
        verify(recipeService, times(1)).getRecipe();
        verify(model, times(1)).addAttribute(eq("recipe"), anySet());
        Set<Recipe>setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}