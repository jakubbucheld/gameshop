package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "articles")
@Getter @Setter @ToString(callSuper = true)
public class Article extends ParentEntity
{
    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn
    private User author;

}
