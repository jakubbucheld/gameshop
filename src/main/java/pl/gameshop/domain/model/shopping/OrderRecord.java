package pl.gameshop.domain.model.shopping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.gameshop.domain.model.ParentEntity;
import pl.gameshop.domain.model.Product;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "order_records")

@Getter @Setter @ToString(callSuper = true, exclude = {"order", "product"})
public class OrderRecord extends ParentEntity
{
    @ManyToOne
    private Product product;

    @Column @Min(1)
    private Integer quantity;

    @Column
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
