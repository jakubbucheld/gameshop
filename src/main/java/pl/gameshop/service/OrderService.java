package pl.gameshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pl.gameshop.domain.model.ShippingData;
import pl.gameshop.domain.model.User;
import pl.gameshop.domain.model.shopping.Order;
import pl.gameshop.domain.model.shopping.OrderRecord;
import pl.gameshop.domain.model.shopping.ShoppingCart;
import pl.gameshop.domain.repository.OrderRecordRepository;
import pl.gameshop.domain.repository.OrderRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service @RequiredArgsConstructor @Scope("session")
public class OrderService
{
    private final OrderRecordRepository orderRecordRepository;
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final HttpSession session;

    public void finalizeOrder(User user,
                              ShippingData shippingData)
    {
        Order order = new Order();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingCart");
        List<OrderRecord> listOfOrderRecords = cart.getOrderRecords();

        order.setFinalPrice(cartService.getCartTotalValue(cart));
        order.setOrderShippingData(shippingData);
        order.setOrderRecords(listOfOrderRecords);

        orderRepository.save(order);
    }
}
