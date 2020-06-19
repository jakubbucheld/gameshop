package pl.gameshop.domain.model.shopping;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.gameshop.domain.model.Product;
import pl.gameshop.domain.model.User;
import pl.gameshop.service.CartService;
import pl.gameshop.service.OrderService;

import java.util.*;

@Component @Scope("session")
@Getter @Setter
public class ShoppingCart
{
    @Autowired
    private OrderService orderService;

    private List<OrderRecord> orderRecords;

    public ShoppingCart()
    {
        this.orderRecords = new ArrayList<>();
    }

    public ShoppingCart(List<OrderRecord> orderRecords)
    {
        this.orderRecords = orderRecords;
    }

    public void clearCart()
    {
        this.orderRecords = new ArrayList<>();
    }


    public void finalizeOrder(User user)
    {
        orderService.finalizeOrder(user);
        this.setOrderRecords(Collections.emptyList());
    }
}



