package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.services.implementation.RecipeServiceImplementation;
import org.h2.index.Index;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class IndexControllerTest {

    private IndexController indexController;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Mock
    private RecipeServiceImplementation recipeServiceImplementation;

    @Mock
    private Model model;

    @Mock
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeServiceImplementation = new RecipeServiceImplementation(recipeRepository);
    }

    @Test
    public void getIndexPage() {

        Set<Recipe> recipeData = new HashSet<>();
        Recipe recipe = new Recipe();
        recipeData.add(recipe);

        when(recipeServiceImplementation.fetchRecipeList()).thenReturn(recipeData);

        model.addAttribute("recipes", recipeData);

        indexController = new IndexController(categoryRepository, unitOfMeasureRepository, recipeServiceImplementation);
        String html_content = indexController.getIndexPage(model);

        assertNotEquals(html_content, "");

        assertEquals(recipeData.size(), 1);
    }
}