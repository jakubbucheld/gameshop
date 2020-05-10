package pl.gameshop.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@MappedSuperclass  // nie tworzymy z tego encji
@Getter @Setter @EqualsAndHashCode(of = "id") /*(of ={ , } - tak naprawde tablica do hashcode'u*/ @ToString(of = "id")

/** EqualsAndHashCode - encje powinny byc porownywane tylko po polach id - takie założenie
 * na encjach nie używać adnotacji @Data */

public abstract class ParentEntity
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
