package SpringBoot.TP.DTO.producto;

import SpringBoot.TP.Entity.Categoria;
import SpringBoot.TP.Entity.Producto;

public record ProductoCreate(
        String nombre,
        String descripcion,
        Double precio,
        int stock,
        String imagen,
        Boolean disponible,
        Long idCategoria
) {
    public Producto toEntity(Categoria categoria) {
        return Producto.builder().
                nombre(nombre).
                descripcion(descripcion).
                precio(precio).
                stock(stock).
                imagen(imagen).
                disponible(disponible).
                categoria(categoria).
                build();
    }
}
