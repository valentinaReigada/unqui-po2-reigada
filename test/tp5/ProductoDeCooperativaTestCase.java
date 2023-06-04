package tp5;
import ar.edu.unq.po2.tp5.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ProductoDeCooperativaTestCase {
	private ProductoDeCooperativa arroz;

	
	@BeforeEach
	public void setUp() {
		arroz = new ProductoDeCooperativa(1, "Arroz", 100.0d, 10);
	}
	
	
	@Test
	public void cuandoUnProductoCooperativaTienePrecio100YDescuentoDe10_EntoncesSuPrecioFinalEs90() {
		
		assertEquals(90.0d, arroz.getPrecio());
	}

}


