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

		ApplicationContext context =
				SpringApplication.run(TpApplication.class, args);

		UsuarioService usuarioService =
				context.getBean(UsuarioService.class);

		CategoriaService categoriaService =
				context.getBean(CategoriaService.class);

		ProductoService productoService =
				context.getBean(ProductoService.class);

		ProductoRepository productoRepository =
				context.getBean(ProductoRepository.class);

		// 1. Crear y guardar las 3 categorías

		CategoriaDTO bebidas = categoriaService.save(
				new CategoriaCreate(
						"Bebidas",
						"Bebidas sin alcohol"
				)
		);

		CategoriaDTO comidas = categoriaService.save(
				new CategoriaCreate(
						"Comidas",
						"Comidas preparadas"
				)
		);

		CategoriaDTO postres = categoriaService.save(
				new CategoriaCreate(
						"Postres",
						"Productos dulces"
				)
		);

		// 2. Crear y guardar los 10 productos

		ProductoDTO agua = productoService.save(
				new ProductoCreate(
						"Agua mineral", "Botella de 500 ml",
						1000.0, 50, "agua.png", true, bebidas.id()
				)
		);

		ProductoDTO gaseosa = productoService.save(
				new ProductoCreate(
						"Gaseosa", "Botella de 1 litro",
						2000.0, 40, "gaseosa.png", true, bebidas.id()
				)
		);

		ProductoDTO jugo = productoService.save(
				new ProductoCreate(
						"Jugo de naranja", "Botella de 500 ml",
						1500.0, 30, "jugo.png", true, bebidas.id()
				)
		);

		ProductoDTO limonada = productoService.save(
				new ProductoCreate(
						"Limonada", "Vaso de 500 ml",
						1800.0, 25, "limonada.png", true, bebidas.id()
				)
		);

		ProductoDTO hamburguesa = productoService.save(
				new ProductoCreate(
						"Hamburguesa", "Hamburguesa con queso",
						5000.0, 20, "hamburguesa.png", true, comidas.id()
				)
		);

		ProductoDTO pizza = productoService.save(
				new ProductoCreate(
						"Pizza", "Pizza de mozzarella",
						7000.0, 15, "pizza.png", true, comidas.id()
				)
		);

		ProductoDTO empanada = productoService.save(
				new ProductoCreate(
						"Empanada", "Empanada de carne",
						1200.0, 60, "empanada.png", true, comidas.id()
				)
		);

		ProductoDTO helado = productoService.save(
				new ProductoCreate(
						"Helado", "Porción de dos bochas",
						2500.0, 30, "helado.png", true, postres.id()
				)
		);

		ProductoDTO flan = productoService.save(
				new ProductoCreate(
						"Flan", "Flan con dulce de leche",
						2000.0, 20, "flan.png", true, postres.id()
				)
		);

		ProductoDTO brownie = productoService.save(
				new ProductoCreate(
						"Brownie", "Porción de chocolate",
						2200.0, 25, "brownie.png", true, postres.id()
				)
		);

		// 3. Crear los 6 detalles a partir de DTOs
		// El subtotal se obtiene como cantidad * precio.

		DetallePedido detalle1 =
				new DetallePedidoCreate(2, agua.precio() * 2).toEntity();
		detalle1.setProducto(
				productoRepository.findById(agua.id()).orElseThrow()
		);
		detalle1.setEliminado(false);

		DetallePedido detalle2 =
				new DetallePedidoCreate(1, hamburguesa.precio()).toEntity();
		detalle2.setProducto(
				productoRepository.findById(hamburguesa.id()).orElseThrow()
		);
		detalle2.setEliminado(false);

		DetallePedido detalle3 =
				new DetallePedidoCreate(1, gaseosa.precio()).toEntity();
		detalle3.setProducto(
				productoRepository.findById(gaseosa.id()).orElseThrow()
		);
		detalle3.setEliminado(false);

		DetallePedido detalle4 =
				new DetallePedidoCreate(1, pizza.precio()).toEntity();
		detalle4.setProducto(
				productoRepository.findById(pizza.id()).orElseThrow()
		);
		detalle4.setEliminado(false);

		DetallePedido detalle5 =
				new DetallePedidoCreate(3, empanada.precio() * 3).toEntity();
		detalle5.setProducto(
				productoRepository.findById(empanada.id()).orElseThrow()
		);
		detalle5.setEliminado(false);

		DetallePedido detalle6 =
				new DetallePedidoCreate(2, helado.precio() * 2).toEntity();
		detalle6.setProducto(
				productoRepository.findById(helado.id()).orElseThrow()
		);
		detalle6.setEliminado(false);

		// 4. Crear los DTOs de los 3 pedidos
		// El ID es null porque todavía no fueron guardados.

		PedidoDTO pedidoDTO1 = new PedidoDTO(
				null,
				LocalDate.now(),
				Estado.PENDIENTE,
				detalle1.getSubtotal() + detalle2.getSubtotal(),
				FormaPago.EFECTIVO,
				Set.of(
						DetallePedidoDTO.toDTO(detalle1),
						DetallePedidoDTO.toDTO(detalle2)
				)
		);

		PedidoDTO pedidoDTO2 = new PedidoDTO(
				null,
				LocalDate.now(),
				Estado.CONFIRMADO,
				detalle3.getSubtotal() + detalle4.getSubtotal(),
				FormaPago.TARJETA,
				Set.of(
						DetallePedidoDTO.toDTO(detalle3),
						DetallePedidoDTO.toDTO(detalle4)
				)
		);

		PedidoDTO pedidoDTO3 = new PedidoDTO(
				null,
				LocalDate.now(),
				Estado.TERMINADO,
				detalle5.getSubtotal() + detalle6.getSubtotal(),
				FormaPago.TRANSFERENCIA,
				Set.of(
						DetallePedidoDTO.toDTO(detalle5),
						DetallePedidoDTO.toDTO(detalle6)
				)
		);

		// 5. Convertir los DTOs de pedido a entidades
		// Los detalles conservan sus referencias a los productos.

		Pedido pedido1 = Pedido.builder()
				.fecha(pedidoDTO1.fecha())
				.estado(pedidoDTO1.estado())
				.total(pedidoDTO1.total())
				.formapago(pedidoDTO1.formaPago())
				.detallepedidos(new HashSet<>(Set.of(detalle1, detalle2)))
				.eliminado(false)
				.build();

		Pedido pedido2 = Pedido.builder()
				.fecha(pedidoDTO2.fecha())
				.estado(pedidoDTO2.estado())
				.total(pedidoDTO2.total())
				.formapago(pedidoDTO2.formaPago())
				.detallepedidos(new HashSet<>(Set.of(detalle3, detalle4)))
				.eliminado(false)
				.build();

		Pedido pedido3 = Pedido.builder()
				.fecha(pedidoDTO3.fecha())
				.estado(pedidoDTO3.estado())
				.total(pedidoDTO3.total())
				.formapago(pedidoDTO3.formaPago())
				.detallepedidos(new HashSet<>(Set.of(detalle5, detalle6)))
				.eliminado(false)
				.build();

		// 6. Crear los 2 usuarios con sus pedidos
		// Emanuel tiene los pedidos 1 y 2; Lucía tiene el pedido 3.

		UsuarioCreate usuario1 = new UsuarioCreate(
				"Emanuel",
				"Mateo",
				"emanuel@example.com",
				"2615551234",
				"claveEmanuel",
				Rol.USUARIO,
				new HashSet<>(Set.of(pedido1, pedido2))
		);

		UsuarioCreate usuario2 = new UsuarioCreate(
				"Lucía",
				"Gómez",
				"lucia@example.com",
				"2615555678",
				"claveLucia",
				Rol.USUARIO,
				new HashSet<>(Set.of(pedido3))
		);

		// 7. Guardar los usuarios, sus pedidos y sus detalles

		usuarioService.save(usuario1);
		usuarioService.save(usuario2);

		System.out.println(
				"Carga finalizada: 3 categorías, 10 productos, "
						+ "3 pedidos, 6 detalles y 2 usuarios."
		);
	}
}