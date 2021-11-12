package bootcamp.junit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import bootcamp.junit.bbdd.BaseDatosServiceI;
import bootcamp.junit.bbdd.BaseDatosServiceImpl;
import bootcamp.junit.model.Articulo;

public class CarritoCompraServiceImpl implements CarritoCompraServiceI{
	
	@Autowired
	private BaseDatosServiceImpl bdd;
	
	Map<Integer, Articulo> storage;
	
	public List<Articulo> listaArticulos = new ArrayList<>();
	
	@Override
	public void limpiarCesta() {
		listaArticulos.clear();
	}

	@Override
	public void addArticulo(Articulo articulo) {
		listaArticulos.add(articulo);
	}

	@Override
	public Integer getnumArticulo() {
		return bdd.lastIndex();
	}

	@Override
	public List<Articulo> getArticulos() {
		return listaArticulos;
	}

	@Override
	public Double totalPrice() {
		Double total = 0D;
		for(Articulo articulo : listaArticulos) {
			total = total + articulo.getPrecio();
		}
		return total;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentajeDescuento) {
		return precio - precio*porcentajeDescuento/100;
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		Double resultado = null;
		Articulo articulo = bdd.findArticuloById(idArticulo);
		if(articulo != null) {
			resultado = calculadorDescuento(articulo.getPrecio(), porcentaje);
			
		}else {
			System.out.println("No se ha encontrado ningun articulo con ID: "+idArticulo);
		}
		
		return resultado;
	}

	@Override
	public Integer testInsertarArticuloById(Integer id, Articulo articulo) {
		return bdd.testInsertarArticuloById(id, articulo);
		
	}

}
