package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
@Getter @Setter @ToString(callSuper = true, exclude = {"author","category","content", "articleCommentaries"})
public class Article extends ParentEntity
{
    @Column
    private String title;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn
    private User author;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    private List<ArticleCommentary> articleCommentaries = new ArrayList<>();
}
