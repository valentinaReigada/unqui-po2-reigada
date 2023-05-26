package ar.edu.unq.po2.tp4;
import java.util.ArrayList;
import java.util.List;

public class Supermercado  {
	private String nombre;
	private String direccion;
	private List<Producto> listaDeProductos	=	new ArrayList<Producto>();
	
	public Supermercado(String nombre, String direccion) {
		this.nombre	=	nombre;
		this.direccion	=	direccion;
	}

	public int getCantidadDeProductos() {
		return listaDeProductos.size();
	}
	
	public void agregarProducto(Producto producto) {
		listaDeProductos.add(producto);
	}
	
	public double getPrecioTotal() {
		return listaDeProductos.stream().mapToDouble(producto -> producto.getPrecio()).sum();
	}
	
}
