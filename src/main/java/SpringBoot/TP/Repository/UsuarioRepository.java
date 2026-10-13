package SpringBoot.TP.Repository;

import SpringBoot.TP.DTO.usuario.UsuarioDTO;
import SpringBoot.TP.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByMail(String mail);
}
