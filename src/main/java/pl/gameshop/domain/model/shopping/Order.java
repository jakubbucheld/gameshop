package pl.gameshop.domain.model.shopping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.gameshop.domain.model.BillingData;
import pl.gameshop.domain.model.ParentEntity;
import pl.gameshop.domain.model.Product;
import pl.gameshop.domain.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "orders")

@Getter @Setter @ToString(callSuper = true)
public class Order extends ParentEntity
{
    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderRecord> orderRecords;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @Column
    LocalDateTime timeCreated;

    @ManyToOne
    @JoinColumn(name = "billing", nullable = false)
    private BillingData orderBillingData;

    @PrePersist
    void timeCreated()
    {
        this.timeCreated = LocalDateTime.now();
    }
}
