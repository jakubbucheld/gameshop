package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games")
@Getter @Setter @ToString(exclude = {"publisher","relatedProducts"}, callSuper = true)
public class Game extends ParentEntity
{
    @Column
    private String name;

    @OneToMany
    @JoinColumn
    private List<Product> relatedProducts;

    @ManyToOne
    private Category category;
}
