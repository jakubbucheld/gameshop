package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
// Spring Boot sam nazywa tabele, ale robimy to ręcznie

@Getter @Setter @ToString(exclude = {"password", "roles", "userAddresses"}, callSuper = true)  // -- callSuper wywołuje toStringa z klasy rodzica
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

    @OneToMany
    private List<ShippingData> userAddresses;

    @CollectionTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username")
    )

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();
    
}
