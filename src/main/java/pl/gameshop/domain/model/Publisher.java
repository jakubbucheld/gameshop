package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publishers")

@Getter @Setter @ToString(exclude = {"relatedUsers", "publishedGames", "publishedProducts"})
public class Publisher extends ParentEntity
{
    @Column
    private String name;

    @OneToMany
    private List<User> relatedUsers;

    @OneToMany
    @JoinColumn(name = "publishers_games")
    private List<Game> publishedGames;

    @OneToMany
    @JoinColumn(name = "publishers_products")
    private List<Product> publishedProducts;
}
