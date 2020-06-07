package pl.gameshop.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.gameshop.domain.model.ParentEntity;
import pl.gameshop.enums.Categories;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter @Setter @ToString(callSuper = true)
public  class Category extends ParentEntity
{
    @Column
    private String name;

    @Column
    private String categoryGroup;
}

