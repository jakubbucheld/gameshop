package pl.gameshop.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter @ToString( callSuper = true)
public abstract class Commentary extends ParentEntity
{
    @Column
    private String content;

    @ManyToOne
    private User author;

    @Column(updatable = false)
    private LocalDateTime timeCreated;

    /** Pole timeCreated jest ustawiane w momencie stworzenia obiektu */
    @PrePersist
    void timeCreated()
    {
        this.timeCreated = LocalDateTime.now();
    }
}
