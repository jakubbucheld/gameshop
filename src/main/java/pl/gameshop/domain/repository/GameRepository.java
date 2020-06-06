package pl.gameshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long>
{
    Game getById(Long id);

    <S extends Game>S save(S entity);
}
