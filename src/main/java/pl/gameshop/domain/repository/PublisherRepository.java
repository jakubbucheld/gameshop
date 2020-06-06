package pl.gameshop.domain.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.Publisher;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Long>
{
    <S extends Publisher>S save(S entity);

    Publisher getById(Long id);

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"relatedUsers"})
    Publisher getWithAllDataById(Long id);

//    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {"relatedUsers})
//    List<Publisher> get
}
