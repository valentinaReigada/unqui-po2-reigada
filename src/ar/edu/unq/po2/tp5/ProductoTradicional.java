package ar.edu.unq.po2.tp5;

public class ProductoTradicional  extends Producto{

	public ProductoTradicional(int codigo, String nombre, double precio) {
		this.codigo		=	codigo;
		this.nombre		=	nombre;
		this.precio		=	precio;
		
	}
	
	public double getPrecio() {
		return this.precio ;
	}
	
}
