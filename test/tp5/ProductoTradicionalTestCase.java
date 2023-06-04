package tp5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.po2.tp5.ProductoTradicional;


class ProductoTradicionalTestCase {
	private ProductoTradicional arroz;
	@BeforeEach
	public void setUp() {
		arroz = new ProductoTradicional(1, "Arroz", 100.0d);
	}
	
	
	@Test
	public void cuandoUnProductoTienePrecio100_EntoncesSuPrecioFinalEs100() {
		
		assertEquals(100.0d, arroz.getPrecio());
	}


}
