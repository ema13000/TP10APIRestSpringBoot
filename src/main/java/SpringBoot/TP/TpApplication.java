package SpringBoot.TP;

import SpringBoot.TP.DTO.categoria.CategoriaCreate;
import SpringBoot.TP.DTO.categoria.CategoriaDTO;
import SpringBoot.TP.DTO.detallePedido.DetallePedidoCreate;
import SpringBoot.TP.DTO.detallePedido.DetallePedidoDTO;
import SpringBoot.TP.DTO.pedido.PedidoDTO;
import SpringBoot.TP.DTO.producto.ProductoCreate;
import SpringBoot.TP.DTO.producto.ProductoDTO;
import SpringBoot.TP.DTO.usuario.UsuarioCreate;
import SpringBoot.TP.Entity.DetallePedido;
import SpringBoot.TP.Entity.Pedido;
import SpringBoot.TP.Enum.Estado;
import SpringBoot.TP.Enum.FormaPago;
import SpringBoot.TP.Enum.Rol;
import SpringBoot.TP.Repository.ProductoRepository;
import SpringBoot.TP.Service.CategoriaService;
import SpringBoot.TP.Service.ProductoService;
import SpringBoot.TP.Service.UsuarioService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TpApplication {

	public static void main(String[] args) {

	}
}