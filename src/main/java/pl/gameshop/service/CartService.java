package pl.gameshop.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Double getCartTotalValue(ShoppingCart cart)
    {
        List<OrderRecord> listOfOrderRecords = cart.getOrderRecords();
        double finalPrice = 0.0;
        for (OrderRecord record: listOfOrderRecords)
        {
            double recordPrice = record.getQuantity() * record.getUnitPrice();
            finalPrice += recordPrice;
        }
        return finalPrice;
    }

    public void addProductToCart(OrderRecord record,
                                         ShoppingCart cart)
    {
        if(record.getQuantity()<1) { return; }
        List<OrderRecord> currentProductList = cart.getOrderRecords();
        boolean ifPresent = false;
        for (OrderRecord current : currentProductList)
        {
            if(current.getProduct().equals(record.getProduct()))
            {
                current.setQuantity((current.getQuantity()+ record.getQuantity()));
                ifPresent = true;
            }
        }
        if(!ifPresent)
        {
                currentProductList.add(record);
                cart.setOrderRecords(currentProductList);
        }
    }

    public void removeProductFromCart(OrderRecord record,
                                              ShoppingCart cart)
    {
        List<OrderRecord> currentProductList = cart.getOrderRecords();
        currentProductList.remove(record);
        cart.setOrderRecords(currentProductList);
    }
}