package ar.edu.unq.po2.tp5;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Caja {
	
	Map<Integer, Integer> stockProductos = new HashMap<>();
	List<Producto> productos	=	new ArrayList<Producto>();
	double montoAPagar	=	0;
	
	public Caja(Map<Integer, Integer>stockProductos, ArrayList<Producto>productos, int montoAPagar ) {
		this.stockProductos	=	stockProductos;
		this.productos		=	productos;
		this.montoAPagar	=	montoAPagar;
	}
	
	public double montoAPagar(){
		return this.montoAPagar;
	}
	
	public void setMontoAPagar(double monto) {
		this.montoAPagar	+= monto;
	}
	
	public int stockDe(Producto producto) {
		return stockProductos.get(producto.codigo);
	}
	
	public void actualizarStockDe(Producto producto) {
		int stockActual = this.stockDe(producto);
		int stockActualizado = (stockActual > 1) ? stockActual -= 1 : 0;
		this.stockProductos.put(producto.codigo, stockActualizado);
	}
	
	public void registrarProducto(Producto producto) {
		this.setMontoAPagar(producto.getPrecio());
		this.actualizarStockDe(producto);
	}
	
	public void registrarProductos(ArrayList<Producto> productos) {
		productos.forEach(producto -> this.registrarProducto(producto));
	}
	

}












