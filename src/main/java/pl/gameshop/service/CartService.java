package pl.gameshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.gameshop.domain.model.Product;
import pl.gameshop.domain.model.shopping.Order;
import pl.gameshop.domain.model.shopping.OrderRecord;
import pl.gameshop.domain.repository.OrderRecordRepository;
import pl.gameshop.domain.repository.OrderRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
@Scope("session")
public class CartService
{
    private final OrderRepository orderRepository;
    private final OrderRecordRepository recordRepository;

    private Order cart;

    public void addProductToCart(Product product,
                                  Integer quantity,
                                  Double unitPrice)
    {
        List<OrderRecord> orderProductsList = cart.getOrderRecords();
        OrderRecord newRecord = new OrderRecord();
        newRecord.setProduct(product);
        newRecord.setQuantity(quantity);
        newRecord.setUnitPrice(unitPrice);

        orderProductsList.add(newRecord);
    }
}
