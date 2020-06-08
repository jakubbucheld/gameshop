package pl.gameshop.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product_commentaries")
public class ProductCommentary extends Commentary
{
    @ManyToOne
    private Product product;

    @Column
    @Size(min = 1, max = 10)
    private Integer score;
}
