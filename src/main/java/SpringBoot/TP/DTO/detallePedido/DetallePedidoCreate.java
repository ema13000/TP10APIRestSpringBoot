package SpringBoot.TP.DTO.detallePedido;

import SpringBoot.TP.Entity.DetallePedido;
import SpringBoot.TP.Entity.Producto;

public record DetallePedidoCreate(
        Long idProducto,
        int cantidad
) {
    public DetallePedido toEntity(Producto producto) {
        return DetallePedido.builder()
                .cantidad(cantidad)
                .producto(producto)
                .subtotal(cantidad * producto.getPrecio())
                .build();
    }
}