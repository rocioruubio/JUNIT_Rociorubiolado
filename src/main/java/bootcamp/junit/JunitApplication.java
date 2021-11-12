package bootcamp.junit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bootcamp.junit.bbdd.BaseDatosServiceI;
import bootcamp.junit.bbdd.BaseDatosServiceImpl;
import bootcamp.junit.model.Articulo;

@SpringBootApplication
public class JunitApplication implements CommandLineRunner {
	
	@Autowired
	private BaseDatosServiceI bdd;

	public static void main(String[] args) {
		SpringApplication.run(JunitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bdd.initBD();
		Articulo articulo = new Articulo("Pijama", 5.95);
		bdd.insertarArticulo(articulo);
		bdd.findArticuloById(bdd.lastIndex());
	}

}
