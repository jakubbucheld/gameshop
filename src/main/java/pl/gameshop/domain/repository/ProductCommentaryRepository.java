package pl.gameshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.ProductCommentary;

import java.util.List;

public interface ProductCommentaryRepository extends JpaRepository<ProductCommentary, Long>
{
    ProductCommentary getOneById(Long id);

    List<ProductCommentary> getAllByAuthor_Id(Long authorId);

    List<ProductCommentary> getAllByProduct_Id(Long productId);

    <S extends ProductCommentary>S save(S entity);
}
