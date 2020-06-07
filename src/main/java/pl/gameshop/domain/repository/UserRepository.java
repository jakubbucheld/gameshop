package pl.gameshop.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.gameshop.domain.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>
{
    User getById(Long id);

    User getByRolesContaining(String role);
}
