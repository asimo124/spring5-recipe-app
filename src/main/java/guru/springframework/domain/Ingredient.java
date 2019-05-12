package guru.springframework.domain;

/**
 * Created by jt on 6/13/17.
 */

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by jt on 6/13/17.
 */
@Data
@EqualsAndHashCode(exclude = {"recipe", "unitOfMeasure"})
@Entity
public class Ingredient {

    public Ingredient() {

    }

    public Ingredient(String description) {
        this.description = description;
    }

    public Ingredient(String description, BigDecimal amount) {
        this.description = description;
        this.amount = amount;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Ingredient(String description, BigDecimal amount, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.recipe = recipe;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
        this.recipe = recipe;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @OneToOne
    private UnitOfMeasure unitOfMeasure;

}
