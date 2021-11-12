package bootcamp.junit.bbdd;

import bootcamp.junit.model.Articulo;

public interface BaseDatosServiceI {
	public void initBD();
	public Articulo findArticuloById(Integer identificador);
	public String insertarArticulo(Articulo articulo);
	public Integer lastIndex();
	public Integer testInsertarArticuloById(Integer id, Articulo articulo);
}
