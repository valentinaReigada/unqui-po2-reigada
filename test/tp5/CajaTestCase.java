package tp5;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp5.Caja;
import ar.edu.unq.po2.tp5.Factura;
import ar.edu.unq.po2.tp5.FacturaImpuesto;
import ar.edu.unq.po2.tp5.FacturaServicio;
import ar.edu.unq.po2.tp5.Producto;
import ar.edu.unq.po2.tp5.ProductoDeCooperativa;
import ar.edu.unq.po2.tp5.ProductoTradicional;

class CajaTestCase {
	private ProductoTradicional arroz;
	private ProductoTradicional leche;
	private ProductoDeCooperativa alfajor;
	private ArrayList<Producto> listaDeProductos ;
	private ArrayList<Factura> listaDeFacturas ;
	private Map<Integer, Integer> stockProductos ;
	private Caja caja;
	private FacturaServicio facturaServicio;
	private FacturaImpuesto facturaImpuesto;
	
	
	
	@BeforeEach
	public void setUp() {
		arroz 	= new ProductoTradicional(1, "Arroz", 100.0d);
		leche 	= new ProductoTradicional(2, "Leche", 80.0d);
		alfajor = new ProductoDeCooperativa(3, "Alfajor", 100.0d, 10);
		stockProductos	 = new HashMap<>();
		stockProductos.put(1, 4);
		stockProductos.put(2, 5);
		stockProductos.put(3, 1);
		listaDeProductos = new ArrayList<Producto>();
		caja  = new Caja(stockProductos);
		
		listaDeFacturas = new ArrayList<Factura>();
		facturaImpuesto	=	new FacturaImpuesto(100);
		facturaServicio	=	new FacturaServicio(1,3);
		
	}
	
	@Test
	public void actualizoEn1ElStockDelProductoArrozEntonces_VaATenerStockDe5() {	

		int stockArroz = this.stockProductos.get(1);
		//actualizo stock de arroz
		stockProductos.put(1, stockArroz + 1);
		assertEquals(stockProductos.get(1), 5);
				
	}
	
	
	@Test
	public void registroLaListaDeProductosEnCajaYVerificoSiElMontoTotalEs270() {
		listaDeProductos.add(leche);
		listaDeProductos.add(arroz);
		listaDeProductos.add(alfajor);
		this.caja.cobrarProductos(listaDeProductos);
		assertEquals(270d, this.caja.getMontoAPagar());
		
	}
	
	@Test 
	public void verificoStockDeProductosUnaVezQueProcesoLosProductosEnCaja() {
		listaDeProductos.add(leche);
		listaDeProductos.add(arroz);
		listaDeProductos.add(alfajor);
		this.caja.cobrarProductos(listaDeProductos);
		
		assertEquals(caja.stockDe(arroz), 3);
		assertEquals(caja.stockDe(leche), 4);
		assertEquals(caja.stockDe(alfajor), 0);
	}
	
	@Test
	public void verificoSiElTotalaPagarDeLaFacturaDeServicioEs_3() {
		assertEquals(facturaServicio.montoAPagar(), 3);
	}
	
	@Test
	public void verificoSiElTotalaPagarDeLaFacturaImpuestoEs_100() {
		assertEquals(facturaImpuesto.montoAPagar(), 100);
	}
	
	@Test 
	public void registroListaDeFacturasEnCajaYVerificoSiElMontoAPagarEs_103() {
		listaDeFacturas.add(facturaImpuesto);
		listaDeFacturas.add(facturaServicio);
		caja.cobrarFacturas(listaDeFacturas);
		
		assertEquals(caja.getMontoAPagar(), 103);
		
	}
	
	
}











