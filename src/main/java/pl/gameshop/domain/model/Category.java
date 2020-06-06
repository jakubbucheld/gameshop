package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import pl.gameshop.domain.model.ParentEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass  // nie tworzymy z tego encji
@Getter @Setter
public abstract class Category extends ParentEntity
{
    @Column
    private String name;
}
