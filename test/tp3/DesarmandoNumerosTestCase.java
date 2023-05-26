package tp3;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.po2.tp3.DesarmandoNumeros;

class DesarmandoNumerosTestCase {

	private DesarmandoNumeros desarmandoNum;
	
	@BeforeEach
	public void setUp() throws Exception {
		desarmandoNum = new DesarmandoNumeros();

		
	}
	@Test
	public void desarmandoNumeros() {
		List<Integer>  listaDeNumeros = new ArrayList<Integer>();
		listaDeNumeros.add(12345);
		listaDeNumeros.add(22422);
		listaDeNumeros.add(5010);
		int numeroGanador = desarmandoNum.nroConMayorCantidadDeParesEn_(listaDeNumeros);
		
		assertEquals(numeroGanador, 22422);
	}

}
