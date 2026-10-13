package SpringBoot.TP.Service;

import SpringBoot.TP.DTO.producto.ProductoCreate;
import SpringBoot.TP.DTO.producto.ProductoDTO;
import SpringBoot.TP.DTO.producto.ProductoEdit;
import SpringBoot.TP.Entity.Categoria;
import SpringBoot.TP.Entity.Producto;
import SpringBoot.TP.Exception.RecursoNoEncontradoException;
import SpringBoot.TP.Repository.CategoriaRepository;
import SpringBoot.TP.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public ProductoDTO save(ProductoCreate productoCreate) {
        Categoria categoria = categoriaRepository.findById(productoCreate.idCategoria()).orElseThrow(()-> new NullPointerException("No se encontro la categoria"));
        Producto producto = productoCreate.toEntity(categoria);
        producto = productoRepository.save(producto);
        return ProductoDTO.toDTO(producto);
    }

    @Override
    public ProductoDTO findById(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new NullPointerException("No se encontro el producto"));
        if (producto.getEliminado() == false) {
            return ProductoDTO.toDTO(producto);
        }
        return null;
    }

    @Override
    public List<ProductoDTO> findAll() {
        List<Producto> productos = productoRepository.findAll();
        List<Producto> resultado = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getEliminado() == false) {
                resultado.add(producto);
            }
        }
        return resultado.stream().map(ProductoDTO :: toDTO).toList();
    }

    @Override
    public ProductoDTO update(ProductoEdit productoEdit, Long idProducto) {
        Producto producto = productoRepository.findById(idProducto).orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el producto" + idProducto));
        Categoria categoria = null;
        if(productoEdit.idCategoria() != null) {
            categoria = categoriaRepository.findById(productoEdit.idCategoria()).orElseThrow(()-> new RecursoNoEncontradoException("No se encontro la categoria" + idProducto));
        }
        productoEdit.applyTo(producto, categoria);
        producto = productoRepository.save(producto);
        return ProductoDTO.toDTO(producto);
    }

    @Override
    public void delete(Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el producto" + id));
        producto.setEliminado(true);
        productoRepository.save(producto);
    }
}
