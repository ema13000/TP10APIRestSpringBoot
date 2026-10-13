package SpringBoot.TP.Repository;

import SpringBoot.TP.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
