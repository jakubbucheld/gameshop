package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "products")
@Getter @Setter @ToString(exclude = {"publisher", "game", "category"} ,callSuper = true)
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
    private Game game;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductCommentary> productCommentaries = new ArrayList<>();
}
