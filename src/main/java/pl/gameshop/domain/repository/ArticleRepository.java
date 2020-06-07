package pl.gameshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.Article;

import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Long>
{
    <S extends Article> S save(S entity);

    List<Article> getAllByAuthor_Id(Long id);

    List<Article> getAllByCategory_Id(Long id);

    void deleteById(Long id);

    Article getById(Long id);
}
