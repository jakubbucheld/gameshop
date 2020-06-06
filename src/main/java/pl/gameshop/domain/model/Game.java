package pl.gameshop.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games")
public class Game extends ParentEntity
{
    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @OneToMany
    @JoinColumn
    private List<Product> relatedProducts;

}
