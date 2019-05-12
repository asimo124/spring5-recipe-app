package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
@Slf4j
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

        log.debug("Loading Mexican Category and Ounce UOM Entities");

        Optional<Category> categoryOptional = categoryRepository.findCategoryByDescription("Mexican");
        //Optional<Category> categoryOptional = categoryRepository.findCategoryByDescription("Mexican2");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Ounce");
        //Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findUnitOfMeasureByDescription("Ounce3");

        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("No Mexican Category found.");
        }
        model.addAttribute("category", categoryOptional.get());

        if (!unitOfMeasureOptional.isPresent()) {
            throw new RuntimeException("No Ounce Unit of Measure found.");
        }
        model.addAttribute("unitOfMeasure", unitOfMeasureOptional.get());

        log.debug("Displaying Index Page template.");
        return "index";
    }
}
