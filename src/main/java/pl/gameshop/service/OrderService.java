package pl.gameshop.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gameshop.domain.model.ShippingData;
import pl.gameshop.domain.model.User;
import pl.gameshop.domain.model.shopping.Order;
import pl.gameshop.domain.model.shopping.OrderRecord;
import pl.gameshop.domain.model.shopping.ShoppingCart;
import pl.gameshop.domain.repository.OrderRecordRepository;
import pl.gameshop.domain.repository.OrderRepository;
import pl.gameshop.web.controller.ProductController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service @RequiredArgsConstructor @Scope("session")
public class OrderService
{
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final OrderRecordRepository orderRecordRepository;
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final HttpSession session;

    public void finalizeOrder(User user)
    {

        Order order = new Order();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingCart");
        log.info("cartToDBPut :: {}", cart);


        List<OrderRecord> listOfOrderRecords = cart.getOrderRecords();
        List<Long> listOfOrderRecordsIds = new ArrayList<>();
        for (OrderRecord record : listOfOrderRecords)
        {
            orderRecordRepository.save(record);
            log.info("czy record ma id? {}", record.getId());
        }
        order.setOrderRecords(listOfOrderRecords);
        log.info("order records in order :: {}", listOfOrderRecords);

        order.setFinalPrice(getOrderTotalValue(listOfOrderRecords));
        log.info("total price :: {}", order.getFinalPrice());
//        order.setOrderShippingData(shippingData);

        order.setUser(user);
        log.info("UserToDBPut :: {}", user);
        orderRepository.save(order);
    }

    private Double getOrderTotalValue(List<OrderRecord> orderRecords)
    {
        double finalPrice = 0.0;
        for (OrderRecord record : orderRecords)
        {
            double recordTotalPrice = record.getQuantity() * record.getUnitPrice();
            finalPrice += recordTotalPrice;
        }
        return finalPrice;
    }


}
