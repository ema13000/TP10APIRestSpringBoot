package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.detallePedido.DetallePedidoCreate;
import SpringBoot.TP.DTO.detallePedido.DetallePedidoDTO;
import SpringBoot.TP.Entity.DetallePedido;
import SpringBoot.TP.Entity.Producto;
import SpringBoot.TP.Exception.RecursoNoEncontradoException;
import SpringBoot.TP.Repository.DetallePedidoRepository;
import SpringBoot.TP.Repository.PedidoRepository;
import SpringBoot.TP.Repository.ProductoRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
    private final DetallePedidoRepository detallePedidoRepository;
    private final ProductoRepository productoRepository;

    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository, ProductoRepository productoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public DetallePedidoDTO save(DetallePedidoCreate detallePedidoCreate) {
        Producto producto = productoRepository.findById(detallePedidoCreate.idProducto()).orElseThrow(() -> new RecursoNoEncontradoException("No se encontró el producto con ID " + detallePedidoCreate.idProducto()));

        DetallePedido detallePedido = detallePedidoCreate.toEntity(producto);

        detallePedido = detallePedidoRepository.save(detallePedido);

        return DetallePedidoDTO.toDTO(detallePedido);
    }

    @Override
    public DetallePedidoDTO findById(Long id) {
        DetallePedido detallePedido = detallePedidoRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("DetallePedido no encontrada" + id));
        if (detallePedido.getEliminado() == false) {
            return DetallePedidoDTO.toDTO(detallePedido);
        }
        return null;
    }

    @Override
    public List<DetallePedidoDTO> findAll() {
        List<DetallePedido> detallePedidos = detallePedidoRepository.findAll();
        List<DetallePedido> resultado = new ArrayList<>();
        for (DetallePedido detallePedido : detallePedidos) {
            if (detallePedido.getEliminado() == false) {
                resultado.add(detallePedido);
            }
        }
        return resultado.stream().map(DetallePedidoDTO::toDTO).toList();
    }

    @Override
    public void deleteById(Long id) {
        DetallePedido detallePedido = detallePedidoRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("DetallePedido no encontrada" + id));
        detallePedido.setEliminado(true);
        detallePedidoRepository.save(detallePedido);
    }
}
