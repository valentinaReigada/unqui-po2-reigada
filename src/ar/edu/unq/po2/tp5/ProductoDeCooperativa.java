package ar.edu.unq.po2.tp5;

public class ProductoDeCooperativa  extends Producto{
	int descuento;
	
	public ProductoDeCooperativa(int codigo, String nombre, double precio, int descuento) {
		this.codigo		=	codigo;
		this.nombre		=	nombre;
		this.precio		=	precio - ((precio * descuento) / 100);
		this.descuento	=	descuento;
	}

	public double getPrecio() {
		return this.precio;
	}
	
	
}
