package SpringBoot.TP.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class Base {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    @Getter @Setter
    private boolean eliminado;
    @Getter @Setter
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }

        if (otro == null
                || Hibernate.getClass(this) != Hibernate.getClass(otro)) {
            return false;
        }

        Base otraEntidad = (Base) otro;

        return getId() != null
                && getId().equals(otraEntidad.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
