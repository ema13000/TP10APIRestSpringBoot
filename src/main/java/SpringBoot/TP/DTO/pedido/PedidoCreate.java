package SpringBoot.TP.DTO.pedido;

import SpringBoot.TP.DTO.detallePedido.DetallePedidoCreate;
import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Enum.Estado;
import SpringBoot.TP.Enum.FormaPago;

import java.time.LocalDate;
import java.util.List;

public record PedidoCreate(LocalDate fecha,
                           Estado estado,
                           FormaPago formaPago,
                           List<DetallePedidoCreate> detalles
) {
    public Pedido toEntity(){
        return Pedido.builder().fecha(fecha).estado(estado).formapago(formaPago).build();
    }
}
