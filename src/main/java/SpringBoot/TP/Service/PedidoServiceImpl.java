package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.detallePedido.DetallePedidoCreate;
import SpringBoot.TP.DTO.pedido.PedidoCreate;
import SpringBoot.TP.DTO.pedido.PedidoDTO;
import SpringBoot.TP.DTO.pedido.PedidoEdit;
import SpringBoot.TP.Entity.DetallePedido;
import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Entity.Producto;
import SpringBoot.TP.Exception.RecursoNoEncontradoException;
import SpringBoot.TP.Repository.PedidoRepository;
import SpringBoot.TP.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public PedidoDTO save(PedidoCreate pedidoCreate) {
        Pedido pedido = pedidoCreate.toEntity();

        for (DetallePedidoCreate detalle : pedidoCreate.detalles()){
            Producto producto = productoRepository.findById(detalle.idProducto()).orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el producto" + detalle.idProducto()));
        pedido.addDetallePedido(detalle.cantidad(), producto);
        }
        pedido = pedidoRepository.save(pedido);
        return PedidoDTO.toDTO(pedido);
    }

    @Override
    public PedidoDTO findById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("No se encontro el pedido buscado" + id));
        if (pedido.getEliminado() == false) {
            return PedidoDTO.toDTO(pedido);
        }
        return null;
    }

    @Override
    public List<PedidoDTO> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getEliminado() == false) {
                resultado.add(pedido);
            }
        }
        return resultado.stream().map(PedidoDTO::toDTO).toList();
    }

    @Override
    public PedidoDTO update(PedidoEdit pedidoEdit, Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(()-> new RecursoNoEncontradoException("No se encontro el pedido buscado" + id));
        pedidoEdit.applyTo(pedido);
        pedido = pedidoRepository.save(pedido);
        return PedidoDTO.toDTO(pedido);
    }

    @Override
    public void deleteById(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el pedido buscado"));
        pedido.setEliminado(true);
        pedidoRepository.save(pedido);
    }
}
