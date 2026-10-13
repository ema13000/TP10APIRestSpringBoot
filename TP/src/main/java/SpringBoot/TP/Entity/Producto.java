package SpringBoot.TP.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Producto extends Base {
    private String nombre;
    private String descripcion;
    private Double precio;
    private int stock;
    private String imagen;
    private Boolean disponible;
    @Builder.Default
    private Boolean eliminado = false;

    @ManyToOne
    private Categoria categoria;
}
