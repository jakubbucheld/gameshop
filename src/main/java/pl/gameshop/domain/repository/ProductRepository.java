package pl.gameshop.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>
{
    Product getById(Long id);

    List<Product> getAllBy();

    <S extends Product>S save(S entity);

    List<Product> getAllByCategory_Id(Long id);

    List<Product> getAllByCategory_NameContaining(String categorySearch);

    List<Product> getAllByNameContaining(String searchPhrase);
}
