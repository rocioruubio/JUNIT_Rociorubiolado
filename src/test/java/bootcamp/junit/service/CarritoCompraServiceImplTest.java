package bootcamp.junit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import bootcamp.junit.bbdd.BaseDatosServiceImpl;
import bootcamp.junit.model.Articulo;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class CarritoCompraServiceImplTest {
	
	@InjectMocks
	CarritoCompraServiceImpl carrito = new CarritoCompraServiceImpl();
	
	@Mock
	BaseDatosServiceImpl bdd;
	
	@BeforeEach
	public void initCarrito() {
		carrito.listaArticulos = new ArrayList<>();
	}
	
	
	@Test
	@Order(4)
	void testLimpiarCesta() {
		testAddArticulo();
		carrito.limpiarCesta();
		assertEquals(0,  carrito.getArticulos().size());
	}

	@Test
	@Order(1)
	void testAddArticulo() {
		Articulo articulo = new Articulo("Blusa", 16.95);
		carrito.addArticulo(articulo);
		assertTrue(carrito.getArticulos().contains(articulo));
	}

	@Test
	@Order(2)
	void testTotalPrice() {
		assertTrue(true);
	}

	@Order(3)
	@Test
	void testCalculadorDescuento() {
		assertTrue(true);
	}
	
	@Test
	@Order(5)
	void testInsertarArticuloById() {
		Articulo articulo = new Articulo("Falda", 12.95);
		Mockito.when(bdd.testInsertarArticuloById(any(Integer.class), any(Articulo.class))).thenReturn(12);
		int id = 0;
		id = carrito.testInsertarArticuloById(12, articulo);
		assertEquals(12, id);
		carrito.addArticulo(articulo);
		assertTrue(carrito.getArticulos().contains(articulo));
		verify(bdd, atLeast(1)).testInsertarArticuloById(any(Integer.class), any(Articulo.class));
	}


}
