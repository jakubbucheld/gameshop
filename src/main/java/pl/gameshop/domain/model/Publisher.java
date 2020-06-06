package pl.gameshop.domain.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher extends ParentEntity
{
    @Column
    private String name;

    @OneToMany
    @JoinColumn
    private List<User> relatedUsers;

    @OneToMany
    @JoinColumn
    private List<Game> publishedGames;

    @OneToMany
    @JoinColumn
    private List<Product> publishedProducts;
}
