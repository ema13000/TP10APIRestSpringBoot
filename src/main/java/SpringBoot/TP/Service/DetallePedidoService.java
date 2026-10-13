package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.detallePedido.DetallePedidoCreate;
import SpringBoot.TP.DTO.detallePedido.DetallePedidoDTO;

import java.util.List;

public interface DetallePedidoService {
    public DetallePedidoDTO save(DetallePedidoCreate detallePedidoCreate);
    public DetallePedidoDTO findById(Long id);
    public List<DetallePedidoDTO> findAll();
    public void deleteById(Long id);
}
