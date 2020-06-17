package pl.gameshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.shopping.OrderRecord;

public interface OrderRecordRepository extends JpaRepository<OrderRecord, Long>
{
    OrderRecord getById(Long id);

    <S extends OrderRecord>S save(S entity);

    void deleteById(Long id);
}
