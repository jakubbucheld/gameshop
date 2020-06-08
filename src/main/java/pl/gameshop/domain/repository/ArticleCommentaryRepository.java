package pl.gameshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.ArticleCommentary;

import java.util.List;

public interface ArticleCommentaryRepository extends JpaRepository<ArticleCommentary, Long>
{
    ArticleCommentary getOneById(Long id);

    List<ArticleCommentary> getAllByAuthor_Id(Long authorId);

    List<ArticleCommentary> getAllByArticle_Id(Long articleId);

    <S extends ArticleCommentary>S save(S entity);
}
