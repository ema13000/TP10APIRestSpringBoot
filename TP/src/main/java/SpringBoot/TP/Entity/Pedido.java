package SpringBoot.TP.Entity;


import Interface.Calculable;
import SpringBoot.TP.Enum.FormaPago;
import SpringBoot.TP.Enum.Estado;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private Double total;
    @Enumerated(EnumType.STRING)
    private FormaPago formapago;
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL)
    private Set<DetallePedido> detallepedidos = new HashSet<>();
    @Builder.Default
    private Boolean eliminado = false;

    public void addDetallePedido(int cantidad, Producto producto) {
        DetallePedido detallepedido = new DetallePedido();

        detallepedido.setCantidad(cantidad);
        detallepedido.setProducto(producto);
        detallepedido.setSubtotal(cantidad * producto.getPrecio());
        this.detallepedidos.add(detallepedido);

        calcularTotal();
    }

    public DetallePedido findeDetallePedidoByProducto(Producto producto) {
        for  (DetallePedido detallepedido : detallepedidos) {
            if (detallepedido.getProducto().equals(producto)) {
                return detallepedido;
            }
        }
        return null;
    }

    public void deleteDetallePedidoByProducto(Producto producto) {
        DetallePedido detallepedido = findeDetallePedidoByProducto(producto);

        if  (detallepedido != null) {
            detallepedidos.remove(detallepedido);
        }
    }

    @Override
    public void calcularTotal() {
        double total = 0;
        for  (DetallePedido detallepedido : detallepedidos) {
            total += detallepedido.getSubtotal();
        }
        this.total = total;
    }
}
