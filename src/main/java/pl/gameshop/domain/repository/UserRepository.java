package pl.gameshop.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.Product;
import pl.gameshop.domain.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>
{
    User getById(Long id);

    List<User> getAllByRolesContaining(String role);

    List<User> getAllByUsernameContaining(String searchPhrase);

    List<User> getAllByEmailContaining(String searchPhrase);
}
