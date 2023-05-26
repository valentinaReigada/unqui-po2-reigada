package tp3;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Counter;
import org.junit.jupiter.api.BeforeEach;
class CounterTestCase {

	private Counter counter;
	
	@BeforeEach
	public void setUp() throws Exception {

		counter = new Counter();
		
		counter.addNumber(1);
		counter.addNumber(3);
		counter.addNumber(5);
		counter.addNumber(7);
		counter.addNumber(9);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(1);
		counter.addNumber(4);
	}
	@Test
	public void testEvenNumbers() {
		int amount = counter.cantidadDePares();
		
		assertEquals(amount,1);
	}
	
}

