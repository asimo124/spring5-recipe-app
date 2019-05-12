package guru.springframework.services.implementation;

import guru.springframework.domain.*;
import guru.springframework.repositories.*;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@Primary
public class RecipeServiceImplementation implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImplementation(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> fetchRecipeList() {

        log.debug("I'm running fetch recipe list!");

        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }
}
