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
    private List<Game> publishedGames;

    @OneToMany
    private List<Product> publishedProducts;
}
