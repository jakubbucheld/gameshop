package pl.gameshop.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.shopping.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{
    Order getById(Long id);

    <S extends Order>S save(S entity);
}
