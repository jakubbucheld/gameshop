package pl.gameshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.gameshop.domain.model.shopping.ShoppingCart;
import pl.gameshop.domain.repository.OrderRecordRepository;
import pl.gameshop.domain.repository.OrderRepository;

@Service @RequiredArgsConstructor @Scope("session")
public class OrderService
{
    private final OrderRecordRepository orderRecordRepository;
    private final OrderRepository orderRepository;

    public void finalizeOrder(ShoppingCart cart)
    {

    }
}
