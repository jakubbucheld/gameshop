package pl.gameshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.Category;
import pl.gameshop.domain.model.Product;
import pl.gameshop.enums.Categories;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    <S extends Category>S save(S entity);

    Category getById(Long id);

    Category getByNameStartsWith(String word);

    List<Category> getAllByCategoryGroupLike(String group);

    List<Category> getAllByNameContaining(String searchPhrase);

    void deleteById(Long id);

}
