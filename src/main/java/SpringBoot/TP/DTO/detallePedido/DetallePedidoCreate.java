package SpringBoot.TP.DTO.detallePedido;

import SpringBoot.TP.Entity.DetallePedido;
import SpringBoot.TP.Entity.Pedido;

public record DetallePedidoCreate(
        Long idProducto,
        int cantidad,
        Double subtotal
) {
    public DetallePedido toEntity() {
        return DetallePedido.builder().
                cantidad(cantidad).
                subtotal(subtotal).
                build();
    }
}
