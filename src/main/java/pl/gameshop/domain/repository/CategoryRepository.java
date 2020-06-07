package pl.gameshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.Category;
import pl.gameshop.enums.Categories;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    <S extends Category>S save(S entity);

    Category getById(Long id);

    List<Category> getAllByCategoryGroupLike(String group);
}
