package bootcamp.junit.service;

import java.util.List;

import bootcamp.junit.model.Articulo;

public interface CarritoCompraServiceI {
	public void limpiarCesta();
	public void addArticulo(Articulo articulo);
	public Integer getnumArticulo();
	public List<Articulo> getArticulos();
	public Double totalPrice();
	public Double calculadorDescuento(Double precio, Double porcentajeDescuento);
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje);
	public Integer testInsertarArticuloById(Integer id, Articulo articulo);
	
}
