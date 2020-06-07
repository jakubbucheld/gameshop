package pl.gameshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.Game;
import pl.gameshop.domain.model.Product;

import java.util.List;
import java.util.Set;

public interface GameRepository extends JpaRepository<Game, Long>
{
    Game getById(Long id);

    List<Game> getAllByCategory_Id(Long id);

    List<Game> getAllByCategory_Name(String categoryName);

    List<Game> getAllByCategory_NameContaining(String categorySearch);

    List<Game> getAllByNameContaining(String searchPhrase);

    <S extends Game>S save(S entity);
}
