package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter @Setter @ToString(callSuper = true)
public class Product extends ParentEntity
{
    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double priceInPln;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @ManyToOne
    @JoinColumn
    private Game game;

    @CollectionTable(name = "products_categories",
        joinColumns = @JoinColumn(name = "name", referencedColumnName = "name"))
    @UniqueElements
    @Column(name = "category")
    private String category;
}
