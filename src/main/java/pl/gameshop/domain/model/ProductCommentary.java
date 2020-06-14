package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product_commentaries")
@Getter @Setter @ToString(callSuper = true, exclude = {"product", "score"})
public class ProductCommentary extends Commentary
{
    @ManyToOne
    private Product product;

    @Column
    private Integer score;
}
