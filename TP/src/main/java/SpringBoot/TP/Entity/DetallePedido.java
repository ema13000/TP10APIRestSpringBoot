package SpringBoot.TP.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class DetallePedido extends Base {
    private int cantidad;
    private Double subtotal;
    @ManyToOne
    private Producto producto;
    @Builder.Default
    private Boolean eliminado = false;
}
