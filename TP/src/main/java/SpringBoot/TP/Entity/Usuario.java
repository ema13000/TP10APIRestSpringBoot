package SpringBoot.TP.Entity;

import SpringBoot.TP.Enum.Rol;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    @ToString.Exclude
    private String contrasena;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @ToString.Exclude
    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pedido> pedidos = new HashSet<>();
    @Builder.Default
    private Boolean eliminado = false;

    public void addPedido(Pedido pedido) {this.pedidos.add(pedido);}
}
