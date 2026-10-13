package SpringBoot.TP.DTO.producto;

import SpringBoot.TP.Entity.Categoria;
import SpringBoot.TP.Entity.Producto;

public record ProductoEdit(
        String nombre,
        String descripcion,
        Double precio,
        Integer stock,
        String imagen,
        Boolean disponible,
        Long idCategoria
) {
    public void applyTo(Producto producto, Categoria categoria) {
        if (nombre != null) {
            producto.setNombre(nombre);
        }
        if (descripcion != null) {
            producto.setDescripcion(descripcion);
        }
        if (precio != null) {
            producto.setPrecio(precio);
        }
        if (stock != null) {
            producto.setStock(stock);
        }
        if (imagen != null) {
            producto.setImagen(imagen);
        }
        if (disponible != null) {
            producto.setDisponible(disponible);
        }
        if (categoria != null) {
            producto.setCategoria(categoria);
        }
    }
}
