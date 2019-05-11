package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    private Set<Recipe> recipes = new HashSet<>();

    public Category() {
        
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Category;
    }

}
