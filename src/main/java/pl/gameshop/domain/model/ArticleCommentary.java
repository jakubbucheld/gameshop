package pl.gameshop.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article_commentaries")
@Getter @Setter @ToString(callSuper = true, exclude = "article")
public class ArticleCommentary extends Commentary
{
    @ManyToOne
    private Article article;
}
