package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
// Spring Boot sam nazywa tabele, ale robimy to ręcznie
@Getter @Setter @ToString(exclude = {"password"}, callSuper = true)  // -- callSuper wywołuje toStringa z klasy rodzica
public class User extends ParentEntity
{
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private Boolean active;
}
