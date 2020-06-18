package pl.gameshop.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import pl.gameshop.domain.model.Product;
import pl.gameshop.domain.model.shopping.Order;
import pl.gameshop.domain.model.shopping.OrderRecord;
import pl.gameshop.domain.model.shopping.ShoppingCart;
import pl.gameshop.domain.repository.OrderRecordRepository;
import pl.gameshop.domain.repository.OrderRepository;
import pl.gameshop.web.controller.ArticleController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service @RequiredArgsConstructor @Scope("session")
public class CartService
{
    private final OrderRepository orderRepository;
    private final OrderRecordRepository recordRepository;


    public void addProductToCart(OrderRecord record,
                                         ShoppingCart cart)
    {
        List<OrderRecord> currentProductList = cart.getOrderRecords();
        currentProductList.add(record);
        cart.setOrderRecords(currentProductList);
    }

    public void removeProductFromCart(OrderRecord record,
                                              ShoppingCart cart)
    {
        List<OrderRecord> currentProductList = cart.getOrderRecords();
        currentProductList.remove(record);
        cart.setOrderRecords(currentProductList);
    }
}